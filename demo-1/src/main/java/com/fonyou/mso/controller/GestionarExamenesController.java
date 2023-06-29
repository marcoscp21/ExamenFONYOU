/**
 * 
 */
package com.fonyou.mso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fonyou.mso.model.DtoRequestContestarExamen;
import com.fonyou.mso.model.DtoRequestCrearExamen;
import com.fonyou.mso.model.DtoResponseRest;
import com.fonyou.mso.model.Estudiante;
import com.fonyou.mso.service.GestionarExamenService;


/**
 * @author marco
 *
 */

@RestController
public class GestionarExamenesController {
	
	private static final String NO_OK = "NO_OK";
	
	@Autowired
	private GestionarExamenService gestionarService;
	
	@PostMapping("/crearExamen")
	public DtoResponseRest crearExamen(@RequestBody DtoRequestCrearExamen request) {
		DtoResponseRest response = null;
		try {
			response = gestionarService.crearExamen(request);
		}
		catch(Exception e) {
			response = new DtoResponseRest();
			response.setCodigo(1);
			response.setNombre("SERVICIO CREAR EXAMEN");
			response.setStatus(NO_OK);
			response.setMensaje(e.getMessage());
		}
		
		return response;
	}
	
	
	@PostMapping("/contestarExamen")
	public DtoResponseRest contestarExamen(@RequestBody DtoRequestContestarExamen request) {
		DtoResponseRest response = null;
		try {
			response = gestionarService.contastarExamen(request);
		}
		catch(Exception e) {
			response = new DtoResponseRest();
			response.setCodigo(1);
			response.setNombre("SERVICIO CONTESTAR EXAMEN");
			response.setStatus(NO_OK);
			response.setMensaje(e.getMessage());
		}
		
		return response;
	}
	
	@PostMapping("/registrarEstudiante")
	public DtoResponseRest registar(@RequestBody Estudiante request) {
		DtoResponseRest response = null;
		try {
			response = gestionarService.registrarAlumno(request);
		}
		catch(Exception e) {
			response = new DtoResponseRest();
			response.setCodigo(1);
			response.setNombre("SERVICIO REGISTRAR ESTUDIANTE");
			response.setStatus(NO_OK);
			response.setMensaje(e.getMessage());
		}
		
		return response;
	}
	
	@GetMapping("/buscarAsignacionExamenes")
	public DtoResponseRest buscarExamenes(@RequestParam int request) {
		DtoResponseRest response = null;
		try {
			response = gestionarService.buscarExamenes(request);
		}
		catch(Exception e) {
			response = new DtoResponseRest();
			response.setCodigo(1);
			response.setNombre("SERVICIO BUSCAR EXAMENES");
			response.setStatus(NO_OK);
			response.setMensaje(e.getMessage());
		}
		
		return response;
	}
	
	@GetMapping("/consultarRespuestas")
	public DtoResponseRest consultarRespuestas(@RequestParam int request) {
		DtoResponseRest response = null;
		try {
			response = gestionarService.consultarRespuestas(request);
		}
		catch(Exception e) {
			response = new DtoResponseRest();
			response.setCodigo(1);
			response.setNombre("SERVICIO CONSULTAR RESPUESTAS DE EXAMENES");
			response.setStatus(NO_OK);
			response.setMensaje(e.getMessage());
		}
		
		return response;
	}
	
	@GetMapping("/consultarCalificacion")
	public DtoResponseRest consultarCalificacion(@RequestParam int idExamen, @RequestParam int idAlumno) {
		DtoResponseRest response = null;
		try {
			response = gestionarService.asignarCalificacion(idExamen, idAlumno);
		}
		catch(Exception e) {
			response = new DtoResponseRest();
			response.setCodigo(1);
			response.setNombre("SERVICIO PARA CONSULTAR CALIFICACION DE EXAMENES");
			response.setStatus(NO_OK);
			response.setMensaje(e.getMessage());
		}
		
		return response;
	}

}
