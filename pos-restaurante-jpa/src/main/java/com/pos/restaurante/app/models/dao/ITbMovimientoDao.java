package com.pos.restaurante.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pos.restaurante.app.models.entity.TbMovimiento;

public interface ITbMovimientoDao extends JpaRepository<TbMovimiento, Long>{

}
