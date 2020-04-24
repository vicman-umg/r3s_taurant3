package com.pos.restaurante.app.controllers;

import java.util.Map;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/cocina")
public class CocinaController {

	@Secured({ "ROLE_USER" })
	@GetMapping(value = "/pedidos")
	public String ver(Map<String, Object> model) {
		return "/pedido/cocinaPedidos";
	}
	
}
