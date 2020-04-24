package com.pos.restaurante.app.models.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pos.restaurante.app.models.dao.ITbProductoDao;
import com.pos.restaurante.app.models.entity.TbProducto;
import com.pos.restaurante.app.models.service.ITbProductoService;

@Service
public class TbProductoServiceImp implements ITbProductoService {

	@Autowired
	private ITbProductoDao tbProductoDao;

	@Override
	@Transactional(readOnly = true)
	public List<TbProducto> findAll() {
		return tbProductoDao.findAll();
	}

	@Override
	@Transactional
	public void save(TbProducto tbProducto) {
		tbProductoDao.save(tbProducto);

	}

	@Override
	@Transactional(readOnly = true)
	public TbProducto findOne(Long id) {
		return tbProductoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		tbProductoDao.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public Page<TbProducto> findAll(Pageable pageable) {
		return tbProductoDao.findAll(pageable);
	}

}
