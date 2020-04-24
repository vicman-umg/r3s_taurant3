package com.pos.restaurante.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pos.restaurante.app.models.entity.TbMovimiento;

public interface ITbMovimientoService {

	public List<TbMovimiento> findAll();

	public void save(TbMovimiento tbMovimiento);

	public TbMovimiento findOne(Long id);

	public void delete(Long id);

	public Page<TbMovimiento> findAll(Pageable pageable);

}
