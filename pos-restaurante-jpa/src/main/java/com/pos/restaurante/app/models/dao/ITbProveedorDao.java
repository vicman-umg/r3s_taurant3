package com.pos.restaurante.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pos.restaurante.app.models.entity.TbProveedor;

public interface ITbProveedorDao extends JpaRepository<TbProveedor, Long>{

}
