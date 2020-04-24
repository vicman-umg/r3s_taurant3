package com.pos.restaurante.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pos.restaurante.app.models.entity.TbProducto;
import com.pos.restaurante.app.models.entity.TbProveedor;
import com.pos.restaurante.app.models.entity.TbStock;
import com.pos.restaurante.app.models.entity.TbSucursal;
import com.pos.restaurante.app.models.service.ITbProductoService;
import com.pos.restaurante.app.models.service.ITbProveedorService;
import com.pos.restaurante.app.models.service.ITbSucursalService;
import com.pos.restaurante.app.util.paginator.PageRender;

@Controller
@RequestMapping(value = "/producto")
public class ProductoController {

	@Autowired
	private ITbProductoService tbProductoService;

	@Autowired
	private ITbSucursalService tbSucursalService;

	@Autowired
	private ITbProveedorService tbProveedorService;

	@Secured({"ROLE_ADMIN"})
//	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping(value = { "/listar", "/"}, method = RequestMethod.GET)
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Map<String, Object> model) {

		// Objetos para almacenar los parametros del Stok a registrar
		TbStock tbStock = new TbStock();
		TbProducto producto = new TbProducto();
		model.put("producto", producto);
		model.put("stock", tbStock);
		
		Pageable pageable = PageRequest.of(page, 14);
		Page<TbProducto> productos = tbProductoService.findAll(pageable);

		// Obtememos nuestras sucursal
		List<TbSucursal> tbSucursal = new ArrayList<>();
		tbSucursal = tbSucursalService.findAll();

		// Obtenemos nuestros proveedores
		List<TbProveedor> tbProveedor = new ArrayList<>();
		tbProveedor = tbProveedorService.findAll();

		PageRender<TbProducto> pageRender = new PageRender<TbProducto>("/producto/listar", productos);
		model.put("titulo", "Listado de clientes");
		model.put("productos", productos);
		model.put("sucursales", tbSucursal);
		model.put("proveedores", tbProveedor);
		model.put("page", pageRender);
		return "/producto/verProductos";
	}

	@PostMapping("/agregar")
	public String guardar(@Valid TbProducto producto, Model model, RedirectAttributes flash) {

		tbProductoService.save(producto);
		// status.setComplete();
		flash.addFlashAttribute("success", "Éxito");
		flash.addFlashAttribute("textoMensaje", "Producto agregado con Éxito!!!");
		return "redirect:/producto/listar";
	}
}
