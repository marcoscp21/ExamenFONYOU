/**
 * 
 */
package com.fonyou.mso.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author marco
 *
 */
public class DtoRequestCrearExamen implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -122649296061425166L;

	private String nombreExamen;
	private String ciudad;
	private String zonaHoraria;
	private String fechaRealizacion;
	
	public DtoRequestCrearExamen() {
		super();
	}
	
	private List<DtoExamen> preguntas;

	public String getNombreExamen() {
		return nombreExamen;
	}

	public void setNombreExamen(String nombreExamen) {
		this.nombreExamen = nombreExamen;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getZonaHoraria() {
		return zonaHoraria;
	}

	public void setZonaHoraria(String zonaHoraria) {
		this.zonaHoraria = zonaHoraria;
	}

	public List<DtoExamen> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<DtoExamen> preguntas) {
		this.preguntas = preguntas;
	}

	public String getFechaRealizacion() {
		return fechaRealizacion;
	}

	public void setFechaRealizacion(String fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}
	
}
