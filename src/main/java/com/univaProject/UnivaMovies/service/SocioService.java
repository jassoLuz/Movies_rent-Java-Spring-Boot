package com.univaProject.UnivaMovies.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univaProject.UnivaMovies.model.ISocioRepository;
import com.univaProject.UnivaMovies.model.Socio;

@Service
public class SocioService {
	
	ISocioRepository isocioRepository;
	
	@Autowired
	public SocioService(ISocioRepository isocioRepository)
	{
		super();
		this.isocioRepository = isocioRepository;
	}
	
	public List<Socio> getSocio(){
			return isocioRepository.findAll();	
		
	}

	public void addSocio(Socio socio) {
		// TODO Auto-generated method stub
		isocioRepository.save(socio);
	}

	public void deleteSocio(Long socioId) {
		// TODO Auto-generated method stub
		if(!isocioRepository.existsById(socioId))		
		{ 
			throw new IllegalStateException("Socio no existe");
		}
		else
		{
		isocioRepository.deleteById(socioId);		
		};
	}

	@Transactional
	public void updateSocio(Long socioId, String nombre, String direccion, String telefono) {
		// TODO Auto-generated method stub
		
		Socio socio = isocioRepository.getById(socioId);
		
		if(socio==null)
		{ 
			throw new IllegalStateException("El socio no existe");
		}
		else
		{
				socio.setNombre(nombre);
				socio.setDireccion(direccion);
				socio.setTelefono(telefono);
		}
		
	};
}
