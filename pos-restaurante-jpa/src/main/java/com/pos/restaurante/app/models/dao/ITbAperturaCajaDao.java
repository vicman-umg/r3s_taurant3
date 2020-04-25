package com.pos.restaurante.app.models.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pos.restaurante.app.models.entity.TbAperturaCaja;

public interface ITbAperturaCajaDao extends JpaRepository<TbAperturaCaja, Integer> {

	@Query("SELECT a FROM TbAperturaCaja a where a.tbUsuario1.usuId= ?1 AND a.apeEstado=?2 AND a.apeFechaSistema=?3")
    List<TbAperturaCaja> findByUsuarioAndEstadoAndFecha(String idUsuario, String estadoCaja, Date fechaApertura);
	
}
