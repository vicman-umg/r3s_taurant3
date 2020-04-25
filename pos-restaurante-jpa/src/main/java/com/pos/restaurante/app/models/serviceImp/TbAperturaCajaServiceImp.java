package com.pos.restaurante.app.models.serviceImp;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pos.restaurante.app.models.dao.ITbAperturaCajaDao;
import com.pos.restaurante.app.models.entity.TbAperturaCaja;
import com.pos.restaurante.app.models.service.ITbAperturaCajaService;

@Service
public class TbAperturaCajaServiceImp implements ITbAperturaCajaService {

	@Autowired
	private ITbAperturaCajaDao tbAperturaCajaDao;

	@Override
	@Transactional(readOnly = true)
	public List<TbAperturaCaja> findAll() {
		return (List<TbAperturaCaja>) tbAperturaCajaDao.findAll();
	}

	@Override
	@Transactional
	public void save(TbAperturaCaja tbAperturaCaja) {
		tbAperturaCajaDao.save(tbAperturaCaja);

	}

	@Override
	@Transactional(readOnly = true)
	public TbAperturaCaja findOne(Integer id) {
		return tbAperturaCajaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		tbAperturaCajaDao.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public Page<TbAperturaCaja> findAll(Pageable pageable) {
		return tbAperturaCajaDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TbAperturaCaja> findByUsuarioAndEstadoAndFecha(String idUsuario, String estadoCaja,
			Date fechaApertura) {
		return (List<TbAperturaCaja>) tbAperturaCajaDao.findByUsuarioAndEstadoAndFecha(idUsuario, estadoCaja,
				fechaApertura);
	}

}
