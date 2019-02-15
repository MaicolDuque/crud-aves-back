package com.ias.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity(name="tont_aves")
public class Ave {
	@Id
	@Column(name="CDAVE")
	private String cdAve;
	@Column(name="DSNOMBRE_COMUN")
	private String nombreComun;
	@Column(name="DSNOMBRE_CIENTIFICO")
	private String nombreCientifico;
		
	
	
	public Ave(String cdAve, String nombreComun, String nombreCientifico) {
		super();
		this.cdAve = cdAve;
		this.nombreComun = nombreComun;
		this.nombreCientifico = nombreCientifico;
	}
	
	
	public Ave() {
		super();
	}


	public String getCdAve() {
		return cdAve;
	}
	public void setCdAve(String cdAve) {
		this.cdAve = cdAve;
	}
	public String getNombreComun() {
		return nombreComun;
	}
	public void setNombreComun(String nombreComun) {
		this.nombreComun = nombreComun;
	}
	public String getNombreCientifico() {
		return nombreCientifico;
	}
	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}


	@Override
	public String toString() {
		return "Ave [cdAve=" + cdAve + ", nombreComun=" + nombreComun + ", nombreCientifico=" + nombreCientifico + "]";
	}
	
	//@OneToMany(mappedBy = "cdAve")
    //private Set<Pais> paises;
	
	
}
