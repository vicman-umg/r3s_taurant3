package com.pos.restaurante.app.models.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pos.restaurante.app.models.dao.ITbSucursalDao;
import com.pos.restaurante.app.models.entity.TbSucursal;
import com.pos.restaurante.app.models.service.ITbSucursalService;

@Service
public class TbSucursalServiceImp implements ITbSucursalService {
@Autowired
ITbSucursalDao iTbSucursalDao;
	
	@Override
	public List<TbSucursal> findAll() {
		return iTbSucursalDao.findAll();
	}

	@Override
	public void save(TbSucursal tbSucursal) {
		iTbSucursalDao.save(tbSucursal);

	}

	@Override
	public TbSucursal findOne(Long id) {
		return iTbSucursalDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		iTbSucursalDao.deleteById(id);
	}

	@Override
	public Page<TbSucursal> findAll(Pageable pageable) {
		return iTbSucursalDao.findAll(pageable);
	}

}
