package com.pos.restaurante.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_app_tipo_movimiento database table.
 * 
 */
@Entity
@Table(name="tb_app_tipo_movimiento")
@NamedQuery(name="TbAppTipoMovimiento.findAll", query="SELECT t FROM TbAppTipoMovimiento t")
public class TbAppTipoMovimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TIPO_MOV", unique=true, nullable=false)
	private Long idTipoMov;

	@Column(name="TIP_MOV_DEBITO_CREDITO", nullable=false, length=45)
	private String tipMovDebitoCredito;

	@Column(name="TIP_MOV_DESCRIPCION", nullable=false, length=255)
	private String tipMovDescripcion;

	//bi-directional many-to-one association to TbMovimiento
	@OneToMany(mappedBy="tbAppTipoMovimiento1")
	private List<TbMovimiento> tbMovimientos1;


	public TbAppTipoMovimiento() {
	}

	public Long getIdTipoMov() {
		return this.idTipoMov;
	}

	public void setIdTipoMov(Long idTipoMov) {
		this.idTipoMov = idTipoMov;
	}

	public String getTipMovDebitoCredito() {
		return this.tipMovDebitoCredito;
	}

	public void setTipMovDebitoCredito(String tipMovDebitoCredito) {
		this.tipMovDebitoCredito = tipMovDebitoCredito;
	}

	public String getTipMovDescripcion() {
		return this.tipMovDescripcion;
	}

	public void setTipMovDescripcion(String tipMovDescripcion) {
		this.tipMovDescripcion = tipMovDescripcion;
	}

	public List<TbMovimiento> getTbMovimientos1() {
		return this.tbMovimientos1;
	}

	public void setTbMovimientos1(List<TbMovimiento> tbMovimientos1) {
		this.tbMovimientos1 = tbMovimientos1;
	}

	public TbMovimiento addTbMovimientos1(TbMovimiento tbMovimientos1) {
		getTbMovimientos1().add(tbMovimientos1);
		tbMovimientos1.setTbAppTipoMovimiento1(this);

		return tbMovimientos1;
	}

	public TbMovimiento removeTbMovimientos1(TbMovimiento tbMovimientos1) {
		getTbMovimientos1().remove(tbMovimientos1);
		tbMovimientos1.setTbAppTipoMovimiento1(null);

		return tbMovimientos1;
	}

}