package com.ias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ias.exception.ResourceNotFoundException;
import com.ias.model.Zona;
import com.ias.repository.ZonaRepository;

@RestController
@RequestMapping("/api")
public class ZonaController {
	@Autowired
	ZonaRepository zonaRepository;
	
	// Get All Ave
	@GetMapping("/zonas")
	public List<Zona> getAllZonas() {
	    return zonaRepository.findAll();	    
	}
	
	
	// Get a Single Ave
	@GetMapping("/zonas/{id}")
	public Zona getAveById(@PathVariable(value = "id") String zonaId) {
	    return zonaRepository.findById(zonaId)
	            .orElseThrow(() -> new ResourceNotFoundException("Zona", "id", zonaId));
	}
}
