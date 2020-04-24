package com.pos.restaurante.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pos.restaurante.app.models.entity.TbStock;

public interface ITbStockService {
	public List<TbStock> findAll();

	public void save(TbStock tbStock);

	public TbStock findOne(Long id);

	public void delete(Long id);

	public Page<TbStock> findAll(Pageable pageable);
	
	public TbStock verificarStock(Long sucursalId, Long proveedorId, Long productoId);
	
	public List<TbStock> obtenerListaStockProductoId(Long productoId);
}
