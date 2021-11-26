package com.univaProject.UnivaMovies.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.univaProject.UnivaMovies.model.Socio;
import com.univaProject.UnivaMovies.service.SocioService;

@RestController
@RequestMapping(path = "api/v1/socio")
public class SocioController {
    private final SocioService socioService;
    
    @Autowired
	public SocioController(SocioService socioService) {
		super();
		this.socioService = socioService;
	}
    
    @GetMapping
    public List<Socio> getSocio(){
    	return socioService.getSocio();
    };
    
    @PostMapping
    public void addSocio(@RequestBody Socio socio) {
    	socioService.addSocio(socio);
    }
    
    @DeleteMapping(path = "{id}")
	public void deleteSocio(@PathVariable("id") Long socioId)
	{
    	socioService.deleteSocio(socioId);
	}
	
	@PutMapping(path = "{id}")
	public void updateSocio(@PathVariable("id") Long socioId, 
			@RequestParam(required=false) String nombre,
			@RequestParam(required=false) String direccion,
			@RequestParam(required=false) String telefono)			
	{
		socioService.updateSocio(socioId,nombre,direccion,telefono);	
	}
    
}
