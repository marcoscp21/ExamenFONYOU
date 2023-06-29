/**
 * 
 */
package com.fonyou.mso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fonyou.mso.model.RespuestasExamen;

/**
 * @author marco
 *
 */
public interface RespuestasExamenDao extends JpaRepository<RespuestasExamen, Integer> {
	
	List<RespuestasExamen> findByIdExamen(@Param("id_examen")int request);
	
	@Query(nativeQuery = true, value = "select * from respuestas_examen "
			+ "where id_examen = :id_examen AND id_estudiante = :id_estudiante")
    List<RespuestasExamen> findByExamenById(@Param("id_examen")int idExamen, @Param("id_estudiante") int idEstudiante);

}
