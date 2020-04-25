package com.pos.restaurante.app.controllers;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pos.restaurante.app.models.entity.TbAperturaCaja;
import com.pos.restaurante.app.models.entity.TbUsuario;
import com.pos.restaurante.app.models.service.ITbAperturaCajaService;
import com.pos.restaurante.app.models.service.ITbUsuarioService;

@Controller
@RequestMapping(value = "/caja")
public class CajaController {

	@Autowired
	private ITbUsuarioService tbUsuarioService;

	@Autowired
	private ITbAperturaCajaService tbAperturaCajaService;

	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	@GetMapping(value = "/aperturaCaja")
	public String ver(Authentication authentication, Map<String, Object> model) {

		// Objeto para recibir parametros de apertura de caja
		TbAperturaCaja tbAperturaCaja = new TbAperturaCaja();

		model.put("userName", authentication.getName());
		Date fechaActual = new Date();
		model.put("fechaActual", new SimpleDateFormat("dd/MM/yyyy").format(fechaActual.getTime()));
		model.put("tbAperturaCaja", tbAperturaCaja);
		return "/caja/abrirCaja";
	}

	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	@PostMapping("/saldoIncialCaja")
	public String guardar(@Valid TbAperturaCaja tbAperturaCaja, Model model, Authentication authentication,
			RedirectAttributes flash) {

		// Obtenemos la fecha para apertura de caja
		Date fechaActual = new Date();
		// Obtenemos los datos de usuario
		TbUsuario tbUsuario = tbUsuarioService.findOne(authentication.getName());
		// Consusltamos si el cajero ya tiene aperturada su caja
		List<TbAperturaCaja> validarApertura = tbAperturaCajaService
				.findByUsuarioAndEstadoAndFecha(tbUsuario.getUsuId(), "OPE", new java.sql.Date(fechaActual.getTime()));

		if (validarApertura.size() > 0) {
			flash.addFlashAttribute("warning", "Precaución");
			flash.addFlashAttribute("textoMensaje", "Usuario ya tiene aperturada caja!!!");
			return "redirect:/caja/aperturaCaja";
		}

		tbAperturaCaja.setApeEstado("OPE");
		tbAperturaCaja.setApeIngreso(new BigDecimal("0"));
		tbAperturaCaja.setApeEgreso(new BigDecimal("0"));
		tbAperturaCaja.setApeFechaSistema(fechaActual);
		tbAperturaCaja.setTbUsuario1(tbUsuario);
		tbAperturaCaja.setTbSucursal1(tbUsuario.getTbAppAsignaSucUsus1().get(0).getTbSucursal1());

		tbAperturaCajaService.save(tbAperturaCaja);
		// status.setComplete();
		flash.addFlashAttribute("success", "Éxito");
		flash.addFlashAttribute("textoMensaje", "Caja aperturada con Éxito!!!");
		return "redirect:/caja/aperturaCaja";
	}

}
