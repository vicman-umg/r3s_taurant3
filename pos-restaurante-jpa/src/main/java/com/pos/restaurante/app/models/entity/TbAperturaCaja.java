package com.pos.restaurante.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the tb_apertura_caja database table.
 * 
 */
@Entity
@Table(name = "tb_apertura_caja")
@NamedQuery(name = "TbAperturaCaja.findAll", query = "SELECT t FROM TbAperturaCaja t")
public class TbAperturaCaja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "APERTURA_ID", unique = true, nullable = false)
	private Long aperturaId;

	@Column(name = "APE_EGRESO", nullable = false, precision = 10, scale = 2)
	private BigDecimal apeEgreso;

	@Column(name = "APE_ESTADO", length = 45)
	private String apeEstado;

	@Temporal(TemporalType.DATE)
	@Column(name = "APE_FECHA_SISTEMA", nullable = false)
	private Date apeFechaSistema;

	@Column(name = "APE_INGRESO", nullable = false, precision = 10, scale = 2)
	private BigDecimal apeIngreso;

	@Column(name = "APE_MONTO_INICIAL", nullable = false, precision = 10, scale = 2)
	private BigDecimal apeMontoInicial;

	// bi-directional many-to-one association to TbSucursal
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUC_ID", nullable = false)
	private TbSucursal tbSucursal1;

	// bi-directional many-to-one association to TbUsuario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USU_ID", nullable = false)
	private TbUsuario tbUsuario1;

	public TbAperturaCaja() {
	}

	public Long getAperturaId() {
		return this.aperturaId;
	}

	public void setAperturaId(Long aperturaId) {
		this.aperturaId = aperturaId;
	}

	public BigDecimal getApeEgreso() {
		return this.apeEgreso;
	}

	public void setApeEgreso(BigDecimal apeEgreso) {
		this.apeEgreso = apeEgreso;
	}

	public String getApeEstado() {
		return this.apeEstado;
	}

	public void setApeEstado(String apeEstado) {
		this.apeEstado = apeEstado;
	}

	public Date getApeFechaSistema() {
		return this.apeFechaSistema;
	}

	public void setApeFechaSistema(Date apeFechaSistema) {
		this.apeFechaSistema = apeFechaSistema;
	}

	public BigDecimal getApeIngreso() {
		return this.apeIngreso;
	}

	public void setApeIngreso(BigDecimal apeIngreso) {
		this.apeIngreso = apeIngreso;
	}

	public BigDecimal getApeMontoInicial() {
		return this.apeMontoInicial;
	}

	public void setApeMontoInicial(BigDecimal apeMontoInicial) {
		this.apeMontoInicial = apeMontoInicial;
	}

	public TbSucursal getTbSucursal1() {
		return this.tbSucursal1;
	}

	public void setTbSucursal1(TbSucursal tbSucursal1) {
		this.tbSucursal1 = tbSucursal1;
	}

	public TbUsuario getTbUsuario1() {
		return this.tbUsuario1;
	}

	public void setTbUsuario1(TbUsuario tbUsuario1) {
		this.tbUsuario1 = tbUsuario1;
	}

}