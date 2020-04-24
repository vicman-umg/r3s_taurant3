package com.pos.restaurante.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the tb_detalle_movimiento database table.
 * 
 */
@Entity
@Table(name = "tb_detalle_movimiento")
@NamedQuery(name = "TbDetalleMovimiento.findAll", query = "SELECT t FROM TbDetalleMovimiento t")
public class TbDetalleMovimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DETALLE_ID", unique = true, nullable = false)
	private Long detalleId;

	@Column(name = "DETMO_CANTIDAD", nullable = false)
	private int detmoCantidad;

	// bi-directional many-to-one association to TbMenu
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MENU_ID", nullable = false)
	private TbMenu tbMenu1;

	// bi-directional many-to-one association to TbMovimiento
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MOV_ID", nullable = false)
	private TbMovimiento tbMovimiento1;

	public TbDetalleMovimiento() {
	}

	public Long getDetalleId() {
		return this.detalleId;
	}

	public void setDetalleId(Long detalleId) {
		this.detalleId = detalleId;
	}

	public int getDetmoCantidad() {
		return this.detmoCantidad;
	}

	public void setDetmoCantidad(int detmoCantidad) {
		this.detmoCantidad = detmoCantidad;
	}

	public TbMenu getTbMenu1() {
		return this.tbMenu1;
	}

	public void setTbMenu1(TbMenu tbMenu1) {
		this.tbMenu1 = tbMenu1;
	}

	public TbMovimiento getTbMovimiento1() {
		return this.tbMovimiento1;
	}

	public void setTbMovimiento1(TbMovimiento tbMovimiento1) {
		this.tbMovimiento1 = tbMovimiento1;
	}

}