package com.pos.restaurante.app.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pos.restaurante.app.models.entity.TbStock;
import com.pos.restaurante.app.models.service.ITbStockService;

@Controller
@RequestMapping(value = "/stock")
public class StockController {

	@Autowired
	ITbStockService iTbStockService;

	@Secured({"ROLE_ADMIN"})
	@PostMapping("/agregar")
	public String guardar(@Valid TbStock tbStock, Model model, RedirectAttributes flash) {

		TbStock tbStock2 = iTbStockService.verificarStock(tbStock.getTbSucursal1().getSucId(),
				tbStock.getTbProveedor1().getProvId(), tbStock.getTbProducto1().getProdId());

		if (tbStock2 != null) {
			
			TbStock tbStock3 = new TbStock();
			tbStock3 = iTbStockService.findOne(tbStock2.getStkId());

			tbStock3.setStkId(tbStock2.getStkId());
			tbStock3.setStkPrecio(tbStock.getStkPrecio().compareTo(tbStock2.getStkPrecio())>0 ? tbStock.getStkPrecio() : (tbStock2.getStkPrecio().add(tbStock.getStkPrecio()).divide(new BigDecimal("2"))));
			tbStock3.setStkCantidad(tbStock2.getStkCantidad() + tbStock.getStkCantidad());
			tbStock3.setStkPesoKilo(tbStock2.getStkPesoKilo().add(tbStock.getStkPesoKilo()== null ? new BigDecimal("0") : tbStock.getStkPesoKilo()));
			tbStock3.setStkPesoLibra((tbStock2.getStkPesoLibra()== null ? new BigDecimal("0"): tbStock2.getStkPesoLibra()).add(tbStock.getStkPesoLibra()== null ? new BigDecimal("0") : tbStock.getStkPesoLibra()));

			iTbStockService.save(tbStock3);

			flash.addFlashAttribute("success", "Éxito");
			flash.addFlashAttribute("textoMensaje", "Stock actualizado con Éxito!!!");
			return "redirect:/producto/listar";

		}

		iTbStockService.save(tbStock);
		// status.setComplete();
		flash.addFlashAttribute("success", "Éxito");
		flash.addFlashAttribute("textoMensaje", "Stock agregado con Éxito!!!");
		return "redirect:/producto/listar";
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping(value = "/verStock/{id}")
	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		List<TbStock> tbStockVerifiExist = iTbStockService.obtenerListaStockProductoId(id);
		if (tbStockVerifiExist.isEmpty()) {
			flash.addFlashAttribute("info", "Info");
			flash.addFlashAttribute("textoMensaje", "El prodcuto no existe, o no tiene Stock registrado!!!");
			return "redirect:/producto/listar";
		}
		
		List<TbStock> tbStock = iTbStockService.obtenerListaStockProductoId(id);
		model.put("tbStock", tbStock);
		return "/producto/verStockId";
	}

}
