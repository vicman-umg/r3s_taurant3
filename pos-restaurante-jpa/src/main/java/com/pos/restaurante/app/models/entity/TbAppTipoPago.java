package com.pos.restaurante.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tb_app_tipo_pago database table.
 * 
 */
@Entity
@Table(name = "tb_app_tipo_pago")
@NamedQuery(name = "TbAppTipoPago.findAll", query = "SELECT t FROM TbAppTipoPago t")
public class TbAppTipoPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TIP_ID", unique = true, nullable = false)
	private Long tipId;

	@Column(name = "TIP_DESCRIPCION", nullable = false, length = 45)
	private String tipDescripcion;

	// bi-directional many-to-one association to TbMovimiento
	@OneToMany(mappedBy = "tbAppTipoPago1")
	private List<TbMovimiento> tbMovimientos1;

	public TbAppTipoPago() {
	}

	public Long getTipId() {
		return this.tipId;
	}

	public void setTipId(Long tipId) {
		this.tipId = tipId;
	}

	public String getTipDescripcion() {
		return this.tipDescripcion;
	}

	public void setTipDescripcion(String tipDescripcion) {
		this.tipDescripcion = tipDescripcion;
	}

	public List<TbMovimiento> getTbMovimientos1() {
		return this.tbMovimientos1;
	}

	public void setTbMovimientos1(List<TbMovimiento> tbMovimientos1) {
		this.tbMovimientos1 = tbMovimientos1;
	}

	public TbMovimiento addTbMovimientos1(TbMovimiento tbMovimientos1) {
		getTbMovimientos1().add(tbMovimientos1);
		tbMovimientos1.setTbAppTipoPago1(this);

		return tbMovimientos1;
	}

	public TbMovimiento removeTbMovimientos1(TbMovimiento tbMovimientos1) {
		getTbMovimientos1().remove(tbMovimientos1);
		tbMovimientos1.setTbAppTipoPago1(null);

		return tbMovimientos1;
	}

}