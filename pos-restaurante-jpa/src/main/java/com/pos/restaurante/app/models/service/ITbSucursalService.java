package com.pos.restaurante.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pos.restaurante.app.models.entity.TbSucursal;

@Service
public interface ITbSucursalService {

	public List<TbSucursal> findAll();

	public void save(TbSucursal tbSucursal);

	public TbSucursal findOne(Long id);

	public void delete(Long id);

	public Page<TbSucursal> findAll(Pageable pageable);
	
}
