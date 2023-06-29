/**
 * 
 */
package com.fonyou.mso.service;

import com.fonyou.mso.model.DtoRequestContestarExamen;
import com.fonyou.mso.model.DtoRequestCrearExamen;
import com.fonyou.mso.model.DtoResponseRest;
import com.fonyou.mso.model.Estudiante;

/**
 * @author marco
 *
 */
public interface GestionarExamenService {
	
	public DtoResponseRest crearExamen(DtoRequestCrearExamen request);
	
	public DtoResponseRest contastarExamen(DtoRequestContestarExamen request);
	
	public DtoResponseRest registrarAlumno(Estudiante request);
	
	public DtoResponseRest buscarExamenes(int request);
	
	public DtoResponseRest consultarRespuestas(int request);
	
	public DtoResponseRest asignarCalificacion(int idExamen, int idAlumno);

}
