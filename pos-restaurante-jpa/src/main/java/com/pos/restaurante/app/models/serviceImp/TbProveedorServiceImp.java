package com.pos.restaurante.app.models.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pos.restaurante.app.models.dao.ITbProveedorDao;
import com.pos.restaurante.app.models.entity.TbProveedor;
import com.pos.restaurante.app.models.service.ITbProveedorService;

@Service
public class TbProveedorServiceImp implements ITbProveedorService {
	
@Autowired
ITbProveedorDao iTbProveedorDao;
	
	@Override
	public List<TbProveedor> findAll() {
		return iTbProveedorDao.findAll();
	}

	@Override
	public void save(TbProveedor tbProveedor) {
		iTbProveedorDao.save(tbProveedor);
	}

	@Override
	public TbProveedor findOne(Long id) {
		return iTbProveedorDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		iTbProveedorDao.deleteById(id);
	}

	@Override
	public Page<TbProveedor> findAll(Pageable pageable) {
		return iTbProveedorDao.findAll(pageable);
	}

}
