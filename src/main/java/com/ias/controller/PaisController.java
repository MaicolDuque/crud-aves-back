package com.ias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ias.model.Pais;
import com.ias.repository.PaisRepository;

@RestController
@RequestMapping("/api")
public class PaisController {
	@Autowired
	PaisRepository paisRepository;
	
	// Get All Pais
	@GetMapping("/paises")
	public List<Pais> getAllPaises() {
	    return paisRepository.findAll();	    
	}

}
