package com.pos.restaurante.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pos.restaurante.app.models.entity.TbProducto;

public interface ITbProductoService {

	public List<TbProducto> findAll();

	public void save(TbProducto tbProducto);

	public TbProducto findOne(Long id);

	public void delete(Long id);

	public Page<TbProducto> findAll(Pageable pageable);

}
