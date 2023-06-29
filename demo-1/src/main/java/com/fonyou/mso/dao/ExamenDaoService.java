package com.fonyou.mso.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fonyou.mso.model.Examen;

public interface ExamenDaoService extends JpaRepository<Examen,Integer>{
	
	
	@Query(nativeQuery = true, value = "select * from examen "
			+ "where ciudad = :ciudad AND zona_horaria = :zona_horaria")
    List<Examen> findExamenByCiudadAndZona(@Param("ciudad")String ciudad, @Param("zona_horaria") String zonaHoraria);

}
