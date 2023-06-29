/**
 * 
 */
package com.fonyou.mso.model;

import java.io.Serializable;

/**
 * @author marco
 *
 */
public class DtoOpciones implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4041296015977521904L;
	
	private int numero;
	private String respuesta;
	
	public DtoOpciones () {
		super();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getrespuesta() {
		return respuesta;
	}

	public void setrespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
	

}
