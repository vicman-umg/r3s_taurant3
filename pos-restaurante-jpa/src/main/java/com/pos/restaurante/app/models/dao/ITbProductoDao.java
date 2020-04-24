package com.pos.restaurante.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pos.restaurante.app.models.entity.TbProducto;

public interface ITbProductoDao extends JpaRepository<TbProducto, Long>{

	@Query("SELECT a FROM TbProducto a ")
    List<TbProducto> findAll();
	
}
