package com.pos.restaurante.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tb_detalle_menu database table.
 * 
 */
@Entity
@Table(name = "tb_detalle_menu")
@NamedQuery(name = "TbDetalleMenu.findAll", query = "SELECT t FROM TbDetalleMenu t")
public class TbDetalleMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DETM_ID", unique = true, nullable = false)
	private Long detmId;

	@Column(name = "DETM_CANTIDAD", nullable = false, length = 45)
	private String detmCantidad;

	@Column(name = "DETM_NOMBRE", nullable = false, length = 45)
	private String detmNombre;

	// bi-directional many-to-one association to TbTipoAlimento
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ALI_ID", nullable = false)
	private TbTipoAlimento tbTipoAlimento1;

	// bi-directional many-to-one association to TbMenu
	@OneToMany(mappedBy = "tbDetalleMenu1")
	private List<TbMenu> tbMenus1;

	public TbDetalleMenu() {
	}

	public Long getDetmId() {
		return this.detmId;
	}

	public void setDetmId(Long detmId) {
		this.detmId = detmId;
	}

	public String getDetmCantidad() {
		return this.detmCantidad;
	}

	public void setDetmCantidad(String detmCantidad) {
		this.detmCantidad = detmCantidad;
	}

	public String getDetmNombre() {
		return this.detmNombre;
	}

	public void setDetmNombre(String detmNombre) {
		this.detmNombre = detmNombre;
	}

	public TbTipoAlimento getTbTipoAlimento1() {
		return this.tbTipoAlimento1;
	}

	public void setTbTipoAlimento1(TbTipoAlimento tbTipoAlimento1) {
		this.tbTipoAlimento1 = tbTipoAlimento1;
	}

	public List<TbMenu> getTbMenus1() {
		return this.tbMenus1;
	}

	public void setTbMenus1(List<TbMenu> tbMenus1) {
		this.tbMenus1 = tbMenus1;
	}

	public TbMenu addTbMenus1(TbMenu tbMenus1) {
		getTbMenus1().add(tbMenus1);
		tbMenus1.setTbDetalleMenu1(this);

		return tbMenus1;
	}

	public TbMenu removeTbMenus1(TbMenu tbMenus1) {
		getTbMenus1().remove(tbMenus1);
		tbMenus1.setTbDetalleMenu1(null);

		return tbMenus1;
	}

}