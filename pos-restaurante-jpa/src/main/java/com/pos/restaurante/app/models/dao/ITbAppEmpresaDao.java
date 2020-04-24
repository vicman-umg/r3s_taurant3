package com.pos.restaurante.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pos.restaurante.app.models.entity.TbAppEmpresa;

public interface ITbAppEmpresaDao extends JpaRepository<TbAppEmpresa, Long> {

}
