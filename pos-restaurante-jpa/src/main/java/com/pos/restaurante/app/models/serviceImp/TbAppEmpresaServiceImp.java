package com.pos.restaurante.app.models.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pos.restaurante.app.models.dao.ITbAppEmpresaDao;
import com.pos.restaurante.app.models.entity.TbAppEmpresa;
import com.pos.restaurante.app.models.service.ITbAppEmpresaService;

@Service
public class TbAppEmpresaServiceImp implements ITbAppEmpresaService {

	@Autowired
	ITbAppEmpresaDao tbAppEmpresaDao;

	@Override
	@Transactional(readOnly = true)
	public List<TbAppEmpresa> findAll() {
		return (List<TbAppEmpresa>) tbAppEmpresaDao.findAll();
	}

	@Override
	@Transactional
	public void save(TbAppEmpresa tbAppEmpresa) {
		tbAppEmpresaDao.save(tbAppEmpresa);

	}

	@Override
	@Transactional(readOnly = true)
	public TbAppEmpresa findOne(Long id) {
		return tbAppEmpresaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		tbAppEmpresaDao.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public Page<TbAppEmpresa> findAll(Pageable pageable) {
		return tbAppEmpresaDao.findAll(pageable);
	}

}
