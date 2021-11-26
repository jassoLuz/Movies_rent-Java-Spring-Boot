package com.univaProject.UnivaMovies.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.univaProject.UnivaMovies.model.Alquiler;
import com.univaProject.UnivaMovies.model.IAlquilerRepository;

@Service
public class AlquilerService {
	
	IAlquilerRepository ialquilerRepository;
	
	@Autowired
	public AlquilerService(IAlquilerRepository ialquilerRepository) {
		super();
		this.ialquilerRepository = ialquilerRepository;
	}

	
	public List<Alquiler> getAlquiler(){
			return ialquilerRepository.findAll();
	}

	public void addAlquiler(Alquiler alquiler) {
		// TODO Auto-generated method stub
		ialquilerRepository.save(alquiler);
		
	}

	public void deleteAlquiler(Long alquilerId) {
		// TODO Auto-generated method stub
		if(!ialquilerRepository.existsById(alquilerId))		
		{ 
			throw new IllegalStateException("Alquiler no existe");
		}
		else
		{
			ialquilerRepository.deleteById(alquilerId);		
		};
	}

	@Transactional
	public void updateAlquiler(Long alquilerId, int dias, float costopordia, String formapago, Date fechaAlquiler) {
		// TODO Auto-generated method stub
		Alquiler alquiler = ialquilerRepository.getById(alquilerId);
		
		if(alquiler==null)
		{ 
			throw new IllegalStateException("El alquiler no existe");
		}
		else
		{
			alquiler.setDias(dias);
			alquiler.setCostopordia(costopordia);
			alquiler.setFormapago(formapago);
			alquiler.setFechaAlquiler(fechaAlquiler);
		}
	}

}
