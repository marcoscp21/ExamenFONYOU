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
public class DtoExamen implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9215164148830895405L;
	private String pregunta;
	private List<DtoOpciones> respuestas;
	private int opcionCorrecta;
	private int porcentaje;

	public DtoExamen() {
		super();
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public List<DtoOpciones> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<DtoOpciones> respuestas) {
		this.respuestas = respuestas;
	}

	public int getOpcionCorrecta() {
		return opcionCorrecta;
	}

	public void setOpcionCorrecta(int opcionCorrecta) {
		this.opcionCorrecta = opcionCorrecta;
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

}
