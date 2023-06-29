/**
 * 
 */
package com.fonyou.mso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.fonyou.mso.model.Preguntas;

/**
 * @author marco
 *
 */
public interface PreguntasDao extends JpaRepository<Preguntas,Integer>{
	List<Preguntas> findByIdExamen(@Param("id_examen")int request);
}
