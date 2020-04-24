package com.pos.restaurante.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pos.restaurante.app.models.entity.TbAppRol;


public interface ITbAppRolService {

	public List<TbAppRol> findAll();

	public void save(TbAppRol tbAppRol);

	public TbAppRol findOne(Long id);

	public void delete(Long id);

	public Page<TbAppRol> findAll(Pageable pageable);
	
}
