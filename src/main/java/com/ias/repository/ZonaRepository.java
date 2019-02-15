package com.ias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ias.model.Zona;

@Repository
public interface ZonaRepository extends JpaRepository<Zona, String>{

}
