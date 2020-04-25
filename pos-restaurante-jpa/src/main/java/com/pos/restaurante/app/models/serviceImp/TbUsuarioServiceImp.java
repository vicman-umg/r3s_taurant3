package com.pos.restaurante.app.models.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pos.restaurante.app.models.dao.ITbUsuarioDao;
import com.pos.restaurante.app.models.entity.TbUsuario;
import com.pos.restaurante.app.models.service.ITbUsuarioService;

@Service
public class TbUsuarioServiceImp implements ITbUsuarioService {
	
	@Autowired
	private ITbUsuarioDao tbUsuarioDao;

	@Override
	public List<TbUsuario> findAll() {
		return tbUsuarioDao.findAll();
	}

	@Override
	public void save(TbUsuario tbUsuario) {
		tbUsuarioDao.save(tbUsuario);

	}

	@Override
	public TbUsuario findOne(String id) {
		return tbUsuarioDao.findById(id).orElse(null);
	}

	@Override
	public void delete(String id) {
		tbUsuarioDao.deleteById(id);
	}

	@Override
	public Page<TbUsuario> findAll(Pageable pageable) {
		return tbUsuarioDao.findAll(pageable);
	}

}
