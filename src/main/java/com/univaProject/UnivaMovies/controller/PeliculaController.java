package com.univaProject.UnivaMovies.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.univaProject.UnivaMovies.model.Pelicula;
import com.univaProject.UnivaMovies.service.PeliculaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(path = "api/v1/peliculas")
public class PeliculaController {
		
	private final PeliculaService peliculaService; 
	
	@Autowired
	public PeliculaController(PeliculaService peliculaService) {
		this.peliculaService = peliculaService; 
	}
	
	@GetMapping
	public List<Pelicula> getPelicula()
	{
		return peliculaService.getPelicula();
	}
	
	@PostMapping
	public void addPelicula(@RequestBody Pelicula pelicula)
	{
		peliculaService.addPelicula(pelicula);
	}
	
	@DeleteMapping(path = "{id}")
	public void deletePelicula(@PathVariable("id") Long peliculaId)
	{
		peliculaService.deletePelicula(peliculaId);
	}
	
	@PutMapping(path = "{id}")
	public void updatePelicula(@PathVariable("id") Long peliculaId, 
			@RequestParam(required=false) String titulo,
			@RequestParam(required=false) String anio,
			@RequestParam(required=false) String clasificacion,
			@RequestParam(required=false) String copias)
	{
	    peliculaService.updatePelicula(peliculaId,titulo,anio,clasificacion,copias);	
	}
}
