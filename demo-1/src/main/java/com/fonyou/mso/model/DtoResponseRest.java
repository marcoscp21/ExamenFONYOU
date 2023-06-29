/**
 * 
 */
package com.fonyou.mso.model;

import java.io.Serializable;

/**
 * @author marco
 * Clase base para retornar respuesta de los servicios
 */
public class DtoResponseRest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5700012171319729985L;
	
	
	private int codigo;
	private String status;
	private String nombre;
	private String mensaje;
	private Object response;
	
	public DtoResponseRest() {
		super();
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	
	

}
