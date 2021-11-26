package com.univaProject.UnivaMovies.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.univaProject.UnivaMovies.model.Alquiler;
import org.springframework.web.bind.annotation.RestController;

import com.univaProject.UnivaMovies.service.AlquilerService;

@RestController
@RequestMapping(path = "api/v1/alquiler")
public class AlquilerController {
	private final AlquilerService alquilerService;

	@Autowired
	public AlquilerController(AlquilerService alquilerService) {
		super();
		this.alquilerService = alquilerService;
	}
	
	@GetMapping
	public List<Alquiler> getAlquiler(){
		return alquilerService.getAlquiler();
	};

	@PostMapping
	public void addAlquiler(@RequestBody Alquiler alquiler)
	{
		alquilerService.addAlquiler(alquiler);
	}
	
	@DeleteMapping(path = "{id}")
	public void deleteAlquiler(@PathVariable("id") Long alquilerId)
	{
    	alquilerService.deleteAlquiler(alquilerId);
	}
	
	@PutMapping(path = "{id}")
	public void updateAlquiler(@PathVariable("id") Long alquilerId, 
			@RequestParam(required=false) int dias,
			@RequestParam(required=false) float costopordia,
			@RequestParam(required=false) String formapago,
			@RequestParam(required=false) Date fechaAlquiler)			
	{
		alquilerService.updateAlquiler(alquilerId,dias,costopordia,formapago,fechaAlquiler);	
	}
}
