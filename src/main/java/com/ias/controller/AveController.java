package com.ias.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ias.exception.ResourceNotFoundException;
import com.ias.model.Ave;
import com.ias.repository.AveRepository;


@RestController
@RequestMapping("/api")
public class AveController {
	@Autowired
    AveRepository aveRepository;
	
	// Get All Ave
	@GetMapping("/aves")
	public List<Ave> getAllAves() {
	    return aveRepository.findAll();	    
	}
	
	
	// Get All Ave by name	an name
	@GetMapping("/avesByZonaAndName/{cdzona}/{nombre}")
	public List<Ave> findAvesZonaAndName(@PathVariable(value = "cdzona") String cdzona, @PathVariable(value = "nombre") String nombre) {
	    return  aveRepository.findAvesZonaAndName(cdzona,nombre);		            
	}
		
	// Get All Ave by name	
	@GetMapping("/avesByName/{nombre}")
	public List<Ave> findAvesByNombre(@PathVariable(value = "nombre") String nombreAve) {
	    return  aveRepository.returnAvesByNombre(nombreAve);		            
	}
	
	
	// Get All Ave by zona	
	@GetMapping("/avesByZona/{zona}")
	public List<Ave> returnAvesByZona(@PathVariable(value = "zona") String zona) {
	    return  aveRepository.returnAvesByZona(zona);		            
	}
	
	
	// Create a new Ave
	@PostMapping("/aves")
	public Ave createAve(@Valid @RequestBody Ave ave) {
	    return aveRepository.save(ave);
	}
	
	// Get a Single Ave
	@GetMapping("/aves/{id}")
	public Ave getAveById(@PathVariable(value = "id") String aveId) {
	    return aveRepository.findById(aveId)
	            .orElseThrow(() -> new ResourceNotFoundException("Ave", "id", aveId));
	}
	
	
	
	
	// Update a Ave
	@PutMapping("/aves/{id}")
	public Ave updateAve(@PathVariable(value = "id") String aveId,
	                                        @Valid @RequestBody Ave aveDetails) {

	    Ave ave = aveRepository.findById(aveId)
	            .orElseThrow(() -> new ResourceNotFoundException("Ave", "id", aveId));

	    ave.setNombreCientifico(aveDetails.getNombreCientifico());
	    ave.setNombreComun(aveDetails.getNombreComun());

	    Ave updateAve = aveRepository.save(ave);
	    return updateAve;
	}
		
	// Delete a Note
	@DeleteMapping("/aves/{id}")
	public ResponseEntity<?> deleteAve(@PathVariable(value = "id") String aveId) {
	    Ave ave = aveRepository.findById(aveId)
	            .orElseThrow(() -> new ResourceNotFoundException("Ave", "id", aveId));

	    aveRepository.delete(ave);

	    return ResponseEntity.ok().build();
	}
	
	// Delete a Note
	
	@DeleteMapping("/avesPais/{id}")
	public void deleteAvePais(@PathVariable(value = "id") String aveId) {	    
	    aveRepository.deleteAveZona(aveId);
	    //return "S";
	}
	
	
		
	
	
}