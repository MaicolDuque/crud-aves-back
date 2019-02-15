package com.ias.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="tont_paises")
public class Pais {
	@Id
	@Column(name="CDPAIS")
	private String cdPais;
	@Column(name="DSNOMBRE")
	private String nombre;
	@Column(name="CDZONA")
	private String cdZona;
	public Pais(String cdPais, String nombre, String cdZona) {
		super();
		this.cdPais = cdPais;
		this.nombre = nombre;
		this.cdZona = cdZona;
	}
	public Pais() {
		super();
	}
	public String getCdPais() {
		return cdPais;
	}
	public void setCdPais(String cdPais) {
		this.cdPais = cdPais;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCdZona() {
		return cdZona;
	}
	public void setCdZona(String cdZona) {
		this.cdZona = cdZona;
	}
	
	@Override
	public String toString() {
		return "Pais [cdPais=" + cdPais + ", nombre=" + nombre + ", cdZona=" + cdZona + "]";
	}

	//@ManyToOne
    //@JoinColumn(name="cdZona")
    //private Zona zona;
	
	
	//@OneToMany(mappedBy = "cdPais")
    //private Set<Ave> aves;
	
}
