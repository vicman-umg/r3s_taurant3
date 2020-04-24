package com.pos.restaurante.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pos.restaurante.app.models.entity.TbSucursal;

public interface ITbSucursalDao extends JpaRepository<TbSucursal, Long>{

}
