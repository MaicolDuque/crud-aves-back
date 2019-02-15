package com.ias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ias.model.Pais;


@Repository
public interface PaisRepository extends JpaRepository<Pais, String>{

}
