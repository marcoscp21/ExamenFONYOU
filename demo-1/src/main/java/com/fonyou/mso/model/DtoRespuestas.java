package com.fonyou.mso.model;

import java.io.Serializable;


public class DtoRespuestas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4041296015977521904L;

	private int idPregunta;
	private int idRespuesta;

	public DtoRespuestas() {
		super();
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
