/**
 * 
 */
package com.fonyou.mso.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.fonyou.mso.model.Estudiante;

/**
 * @author marco
 *
 */
public interface EstudianteDao extends JpaRepository<Estudiante, Integer> {
	
    Estudiante findById(@Param("id_estudiante")int request);

}
