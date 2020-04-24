package com.pos.restaurante.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pos.restaurante.app.models.entity.TbAperturaCaja;

public interface ITbAperturaCajaService {

	public List<TbAperturaCaja> findAll();

	public void save(TbAperturaCaja tbAperturaCaja);

	public TbAperturaCaja findOne(Integer id);

	public void delete(Integer id);

	public Page<TbAperturaCaja> findAll(Pageable pageable);

}
