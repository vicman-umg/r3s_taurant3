package com.pos.restaurante.app.models.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pos.restaurante.app.models.dao.ITbStockDao;
import com.pos.restaurante.app.models.entity.TbStock;
import com.pos.restaurante.app.models.service.ITbStockService;

@Transactional
@Service
public class TbStokServiceImp implements ITbStockService {

	@Autowired
	ITbStockDao tbStokDao;

	@Override
	public List<TbStock> findAll() {
		return tbStokDao.findAll();
	}

	@Override
	public void save(TbStock tbStock) {
		tbStokDao.save(tbStock);
	}

	@Override
	public TbStock findOne(Long id) {
		return tbStokDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		tbStokDao.deleteById(id);
	}

	@Override
	public Page<TbStock> findAll(Pageable pageable) {
		return tbStokDao.findAll(pageable);
	}

	@Override
	public TbStock verificarStock(Long sucId, Long provId, Long prodId) {
		return tbStokDao.findBySucursalAndProveedorAndProducto(sucId, provId, prodId);
	}

	@Override
	public List<TbStock> obtenerListaStockProductoId(Long productoId) {
		return tbStokDao.findByStockProductoId(productoId);
	}
	

}
