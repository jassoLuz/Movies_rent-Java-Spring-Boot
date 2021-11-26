package com.univaProject.UnivaMovies.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univaProject.UnivaMovies.model.IPeliculaRepository;
import com.univaProject.UnivaMovies.model.Pelicula;


@Service
public class PeliculaService {
	
	IPeliculaRepository ipeliculaRepository;
	
	
	@Autowired
	public PeliculaService(IPeliculaRepository ipeliculaRepository) {
		super();
		this.ipeliculaRepository = ipeliculaRepository;
	}



	public List<Pelicula> getPelicula()
	{
		
		return ipeliculaRepository.findAll();
		
	}



	public void addPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		Optional<Pelicula> peliculaOp = ipeliculaRepository.findByName(pelicula.getTitulo());
		
		if(!peliculaOp.isPresent()) { 
		ipeliculaRepository.save(pelicula);
		}
		else
		{
			throw new IllegalStateException("La película ya existe");
		}
	}



	public void deletePelicula(Long peliculaId) {
		// TODO Auto-generated method stub
		if(!ipeliculaRepository.existsById(peliculaId))		
		{ 
			throw new IllegalStateException("La película no existe");
		}
		else
		{
			ipeliculaRepository.deleteById(peliculaId);
		}
	}


	@Transactional
	public void updatePelicula(Long peliculaId, String titulo, String anio, String clasificacion, String copias) {
		// TODO Auto-generated method stub
		Pelicula pelicula = ipeliculaRepository.getById(peliculaId);
		
		if(pelicula==null)
		{ 
			throw new IllegalStateException("La película no existe");
		}
		else
		{
			if(titulo != "" && pelicula.getTitulo().compareTo(titulo) != 0 )
				pelicula.setTitulo(titulo);
			
			if(clasificacion != "" && pelicula.getClasificacion().compareTo(clasificacion) != 0 )
				pelicula.setClasificacion(clasificacion);
			
		}
	}

}
