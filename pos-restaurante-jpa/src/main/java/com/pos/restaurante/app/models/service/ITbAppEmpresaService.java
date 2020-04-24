package com.pos.restaurante.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pos.restaurante.app.models.entity.TbAppEmpresa;

public interface ITbAppEmpresaService {

	public List<TbAppEmpresa> findAll();

	public void save(TbAppEmpresa tbAppEmpresa);

	public TbAppEmpresa findOne(Long id);

	public void delete(Long id);

	public Page<TbAppEmpresa> findAll(Pageable pageable);

}
