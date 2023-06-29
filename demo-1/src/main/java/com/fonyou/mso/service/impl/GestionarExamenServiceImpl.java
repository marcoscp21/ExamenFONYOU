/**
 * 
 */
package com.fonyou.mso.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fonyou.mso.dao.EstudianteDao;
import com.fonyou.mso.dao.ExamenDaoService;
import com.fonyou.mso.dao.PreguntasDao;
import com.fonyou.mso.dao.RespuestasDao;
import com.fonyou.mso.dao.RespuestasExamenDao;
import com.fonyou.mso.model.DtoExamen;
import com.fonyou.mso.model.DtoOpciones;
import com.fonyou.mso.model.DtoRequestContestarExamen;
import com.fonyou.mso.model.DtoRequestCrearExamen;
import com.fonyou.mso.model.DtoResponseRest;
import com.fonyou.mso.model.DtoRespuestas;
import com.fonyou.mso.model.Estudiante;
import com.fonyou.mso.model.Examen;
import com.fonyou.mso.model.Preguntas;
import com.fonyou.mso.model.Respuestas;
import com.fonyou.mso.model.RespuestasExamen;
import com.fonyou.mso.service.GestionarExamenService;

/**
 * @author marco
 *
 */

@Component
public class GestionarExamenServiceImpl implements GestionarExamenService {

	private static final String DATETIMEFORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final String NO_OK = "NO_OK";

	@Autowired
	private ExamenDaoService examenDao;

	@Autowired
	private PreguntasDao preguntasDao;

	@Autowired
	private RespuestasDao respuestasDao;

	@Autowired
	private RespuestasExamenDao respuestaExamenDao;

	@Autowired
	private EstudianteDao estudianteDao;

	@Override
	public DtoResponseRest crearExamen(DtoRequestCrearExamen request) {
		DtoResponseRest response = new DtoResponseRest();

		try {

			HashMap<String, Integer> datosResponse = new HashMap<>();

			// insertamos datos en base para registrar el examen
			Examen examen = new Examen();
			examen.setNombre(request.getNombreExamen());
			examen.setCiudad(request.getCiudad());
			examen.setZonaHoraria(request.getZonaHoraria());

			SimpleDateFormat formato = new SimpleDateFormat(DATETIMEFORMAT);
			Date dataFormateada = formato.parse(request.getFechaRealizacion());

			examen.setFechaRealizacion(dataFormateada);
			examen = examenDao.save(examen);

			datosResponse.put("id_examen", examen.getIdExamen());
			int numero = 1;

			for (DtoExamen iter : request.getPreguntas()) {
				Preguntas preguntas = new Preguntas();
				preguntas.setIdExamen(examen.getIdExamen());
				preguntas.setPorcentaje(iter.getPorcentaje());
				preguntas.setPregunta(iter.getPregunta());
				preguntas.setRespuestaCorrecta(iter.getOpcionCorrecta());
				preguntas.setIdPregunta(numero);
				preguntas = preguntasDao.save(preguntas);

				for (DtoOpciones aux : iter.getRespuestas()) {
					Respuestas respuesta = new Respuestas();
					respuesta.setRespuesta(aux.getrespuesta());
					respuesta.setIdPregunta(preguntas.getIdPregunta());
					respuestasDao.save(respuesta);
				}
				numero++;
			}

			response.setCodigo(0);
			response.setNombre("SERVICIO CREAR EXAMEN");
			response.setStatus("OK");
			response.setMensaje("Examen insertado de forma correcta");
			response.setResponse(datosResponse);

		} catch (Exception e) {
			response = new DtoResponseRest();
			response.setCodigo(2);
			response.setNombre("SERVICIO CREAR EXAMEN");
			response.setStatus(NO_OK);
			response.setMensaje(e.getMessage());
		}

		return response;
	}

	@Override
	public DtoResponseRest contastarExamen(DtoRequestContestarExamen request) {
		DtoResponseRest response = new DtoResponseRest();

		try {

			RespuestasExamen respuestasExamen = null;
			for (DtoRespuestas iter : request.getPreguntas()) {
				respuestasExamen = new RespuestasExamen();
				respuestasExamen.setIdEstudiante(request.getIdEstudiante());
				respuestasExamen.setIdExamen(request.getIdExamen());
				respuestasExamen.setIdPregunta(iter.getIdPregunta());
				respuestasExamen.setIdRespuesta(iter.getIdRespuesta());
				respuestaExamenDao.save(respuestasExamen);
			}

			response.setCodigo(0);
			response.setNombre("SERVICIO CONTESTAR EXAMEN");
			response.setStatus("OK");
			response.setMensaje("Respuestas insertadas de forma correcta");

		} catch (Exception e) {
			response = new DtoResponseRest();
			response.setCodigo(2);
			response.setNombre("SERVICIO CONTESTAR EXAMEN");
			response.setStatus(NO_OK);
			response.setMensaje(e.getMessage());
		}

		return response;
	}

	@Override
	public DtoResponseRest registrarAlumno(Estudiante request) {
		DtoResponseRest response = new DtoResponseRest();

		try {

			request = estudianteDao.save(request);

			response.setCodigo(0);
			response.setNombre("SERVICIO REGISTRAR ESTUDIANTE");
			response.setStatus("OK");
			response.setMensaje("Estudiante registrado de forma correcta");
			response.setResponse(request);

		} catch (Exception e) {
			response = new DtoResponseRest();
			response.setCodigo(2);
			response.setNombre("SERVICIO REGISTRAR ESTUDIANTE");
			response.setStatus(NO_OK);
			response.setMensaje(e.getMessage());
		}

		return response;
	}

	@Override
	public DtoResponseRest buscarExamenes(int request) {
		DtoResponseRest response = new DtoResponseRest();

		try {

			HashMap<String, String> datosExamen = null;
			HashMap<String, Object> datosResponse = new HashMap<>();

			Estudiante estudiantesList = estudianteDao.findById(request);
			List<Examen> examenes = examenDao.findExamenByCiudadAndZona(estudiantesList.getCiudad(),
					estudiantesList.getZonaHoraria());

			SimpleDateFormat formato = new SimpleDateFormat(DATETIMEFORMAT);
			int numero = 1;
			for (Examen iter : examenes) {
				datosExamen = new HashMap<>();
				datosExamen.put("idExamen", String.valueOf(iter.getIdExamen()));
				datosExamen.put("nombre del examen", iter.getNombre());
				String fecha = formato.format(iter.getFechaRealizacion());
				datosExamen.put("Fecha de examen", fecha);
				datosResponse.put("Examen numero " + numero, datosExamen);
				numero++;
			}

			response.setCodigo(0);
			response.setNombre("SERVICIO BUSCAR EXAMENES");
			response.setStatus("OK");
			response.setMensaje("Examenes del estudiante");
			response.setResponse(datosResponse);

		} catch (Exception e) {
			response = new DtoResponseRest();
			response.setCodigo(2);
			response.setNombre("SERVICIO BUSCAR EXAMENES");
			response.setStatus(NO_OK);
			response.setMensaje(e.getMessage());
		}

		return response;
	}

	@Override
	public DtoResponseRest consultarRespuestas(int request) {
		DtoResponseRest response = new DtoResponseRest();

		try {
			HashMap<String, String> respuestasResponse = null;
			HashMap<String, Object> datosResponse = new HashMap<>();
			List<RespuestasExamen> respuestas = respuestaExamenDao.findByIdExamen(request);
			List<Preguntas> preguntas = preguntasDao.findByIdExamen(request);

			for (RespuestasExamen iter : respuestas) {
				respuestasResponse = new HashMap<>();
				respuestasResponse.put("Respuesta", String.valueOf(iter.getIdRespuesta()));
				for (Preguntas aux : preguntas) {
					if (aux.getIdPregunta() == iter.getIdPregunta()) {
						respuestasResponse.put("Pregunta", aux.getPregunta());
					}
				}
				datosResponse.put("pregunta " + iter.getIdPregunta(), respuestasResponse);

			}

			response.setCodigo(0);
			response.setNombre("SERVICIO CONSULTAR RESPUESTAS DE EXAMENES");
			response.setStatus("OK");
			response.setMensaje("Respuestas examen");
			response.setResponse(datosResponse);

		} catch (Exception e) {
			response = new DtoResponseRest();
			response.setCodigo(2);
			response.setNombre("SERVICIO CONSULTAR RESPUESTAS DE EXAMENES");
			response.setStatus(NO_OK);
			response.setMensaje(e.getMessage());
		}

		return response;
	}

	@Override
	public DtoResponseRest asignarCalificacion(int idExamen, int idAlumno) {
		DtoResponseRest response = new DtoResponseRest();

		try {
			HashMap<String, Integer> calificaciones = new HashMap<>();
			List<RespuestasExamen> respuestas = respuestaExamenDao.findByExamenById(idExamen, idAlumno);
			List<Preguntas> preguntas = preguntasDao.findByIdExamen(idExamen);
			int porcentaje = 0;

			for (RespuestasExamen iter : respuestas) {
				for (Preguntas aux : preguntas) {
					if (aux.getIdPregunta() == iter.getIdPregunta()
							&& iter.getIdRespuesta() == aux.getRespuestaCorrecta()) {
						porcentaje += aux.getPorcentaje();
						break;
					}
				}
			}
			calificaciones.put("Tu calificacion es :", porcentaje);

			response.setCodigo(0);
			response.setNombre("SERVICIO PARA CONSULTAR CALIFICACION DE EXAMENES");
			response.setStatus("OK");
			response.setMensaje("Calificacion de examenes");
			response.setResponse(calificaciones);

		} catch (Exception e) {
			response = new DtoResponseRest();
			response.setCodigo(2);
			response.setNombre("SERVICIO PARA CONSULTAR CALIFICACION DE EXAMENES");
			response.setStatus(NO_OK);
			response.setMensaje(e.getMessage());
		}

		return response;
	}

}
