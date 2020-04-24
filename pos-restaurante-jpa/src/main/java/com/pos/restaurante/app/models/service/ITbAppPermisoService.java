package com.pos.restaurante.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pos.restaurante.app.models.entity.TbAppPermiso;

public interface ITbAppPermisoService {

	public List<TbAppPermiso> findAll();

	public void save(TbAppPermiso tbAppPermiso);

	public TbAppPermiso findOne(Long id);

	public void delete(Long id);

	public Page<TbAppPermiso> findAll(Pageable pageable);

}
