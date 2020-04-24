package com.pos.restaurante.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pos.restaurante.app.models.entity.TbUsuario;

public interface ITbUsuarioDao extends JpaRepository<TbUsuario, String>{
	@Query("select u from TbUsuario u where u.usuId = ?1")
	public TbUsuario findByUsuarioCodigo(String term);
}
