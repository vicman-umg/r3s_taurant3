package com.pos.restaurante.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pos.restaurante.app.models.entity.TbProveedor;

public interface ITbProveedorService {
	public List<TbProveedor> findAll();

	public void save(TbProveedor tbProveedor);

	public TbProveedor findOne(Long id);

	public void delete(Long id);

	public Page<TbProveedor> findAll(Pageable pageable);

}
