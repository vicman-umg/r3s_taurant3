package com.pos.restaurante.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * The persistent class for the tb_menu database table.
 * 
 */
@Entity
@Table(name = "tb_menu")
@NamedQuery(name = "TbMenu.findAll", query = "SELECT t FROM TbMenu t")
public class TbMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MENU_ID", unique = true, nullable = false)
	private Long menuId;

	@Column(name = "MENU_DISPONIBLE", nullable = false)
	private byte menuDisponible;

	@Column(name = "MENU_NOMBRE", nullable = false, length = 45)
	private String menuNombre;

	@Column(name = "MENU_PRECIO", nullable = false, precision = 10, scale = 2)
	private BigDecimal menuPrecio;

	// bi-directional many-to-one association to TbDetalleMovimiento
	@OneToMany(mappedBy = "tbMenu1")
	private List<TbDetalleMovimiento> tbDetalleMovimientos1;

	// bi-directional many-to-one association to TbDetalleMenu
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DETM_ID", nullable = false)
	private TbDetalleMenu tbDetalleMenu1;

	public TbMenu() {
	}

	public Long getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public byte getMenuDisponible() {
		return this.menuDisponible;
	}

	public void setMenuDisponible(byte menuDisponible) {
		this.menuDisponible = menuDisponible;
	}

	public String getMenuNombre() {
		return this.menuNombre;
	}

	public void setMenuNombre(String menuNombre) {
		this.menuNombre = menuNombre;
	}

	public BigDecimal getMenuPrecio() {
		return this.menuPrecio;
	}

	public void setMenuPrecio(BigDecimal menuPrecio) {
		this.menuPrecio = menuPrecio;
	}

	public List<TbDetalleMovimiento> getTbDetalleMovimientos1() {
		return this.tbDetalleMovimientos1;
	}

	public void setTbDetalleMovimientos1(List<TbDetalleMovimiento> tbDetalleMovimientos1) {
		this.tbDetalleMovimientos1 = tbDetalleMovimientos1;
	}

	public TbDetalleMovimiento addTbDetalleMovimientos1(TbDetalleMovimiento tbDetalleMovimientos1) {
		getTbDetalleMovimientos1().add(tbDetalleMovimientos1);
		tbDetalleMovimientos1.setTbMenu1(this);

		return tbDetalleMovimientos1;
	}

	public TbDetalleMovimiento removeTbDetalleMovimientos1(TbDetalleMovimiento tbDetalleMovimientos1) {
		getTbDetalleMovimientos1().remove(tbDetalleMovimientos1);
		tbDetalleMovimientos1.setTbMenu1(null);

		return tbDetalleMovimientos1;
	}

	public TbDetalleMenu getTbDetalleMenu1() {
		return this.tbDetalleMenu1;
	}

	public void setTbDetalleMenu1(TbDetalleMenu tbDetalleMenu1) {
		this.tbDetalleMenu1 = tbDetalleMenu1;
	}

}