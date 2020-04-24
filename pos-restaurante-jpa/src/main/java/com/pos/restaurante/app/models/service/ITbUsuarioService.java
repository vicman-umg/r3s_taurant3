package com.pos.restaurante.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pos.restaurante.app.models.entity.TbUsuario;

public interface ITbUsuarioService {

	public List<TbUsuario> findAll();

	public void save(TbUsuario tbUsuario);

	public TbUsuario findOne(String id);

	public void delete(String id);

	public Page<TbUsuario> findAll(Pageable pageable);

	
}
