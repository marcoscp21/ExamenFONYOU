/**
 * 
 */
package com.fonyou.mso.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author marco
 *
 */
@Entity
@Table(name = "respuestas_examen")
public class RespuestasExamen implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2559078608719874664L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_registro")
	private int idRegistro;
	
	@Column(name = "id_estudiante")
	private int idEstudiante;
	
	@Column(name = "id_examen")
	private int idExamen;
	
	@Column(name = "id_pregunta")
	private int idPregunta;
	
	@Column(name = "id_respuesta")
	private int idRespuesta;

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public int getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}

	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public int getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}
	
	

}
