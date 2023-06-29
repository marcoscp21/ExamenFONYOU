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

public class DtoRequestContestarExamen implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4041296015977521904L;
	
	private int idExamen;
	private int idEstudiante;
	private List<DtoRespuestas> preguntas;
	
	public int getIdExamen() {
		return idExamen;
	}
	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}
	public int getIdEstudiante() {
		return idEstudiante;
	}
	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	public List<DtoRespuestas> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(List<DtoRespuestas> preguntas) {
		this.preguntas = preguntas;
	}
	
	

}
