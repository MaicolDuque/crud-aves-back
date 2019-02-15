package com.ias.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity(name="tont_zonas")
public class Zona {
	@Id
	@Column(name="CDZONA")
	private String cdZona;
	@Column(name="DSNOMBRE")
	private String nombre;
	public Zona(String cdZona, String nombre) {
		super();
		this.cdZona = cdZona;
		this.nombre = nombre;
	}
	public Zona() {
		super();
	}
	public String getCdZona() {
		return cdZona;
	}
	public void setCdZona(String cdZona) {
		this.cdZona = cdZona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Zona [cdZona=" + cdZona + ", nombre=" + nombre + "]";
	}	
	
	//@OneToMany(mappedBy = "cdZona")
    //private Set<Pais> paises;
	
	
}
