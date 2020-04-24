package com.pos.restaurante.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the tb_modulo database table.
 * 
 */
@Entity
@Table(name = "tb_modulo")
@NamedQuery(name = "TbModulo.findAll", query = "SELECT t FROM TbModulo t")
public class TbModulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MODULO_ID", unique = true, nullable = false, length = 3)
	private String moduloId;

	@Temporal(TemporalType.DATE)
	@Column(name = "MODULO_FECHA_FIN_MES", nullable = false)
	private Date moduloFechaFinMes;

	@Temporal(TemporalType.DATE)
	@Column(name = "MODULO_FECHA_SISTEMA", nullable = false)
	private Date moduloFechaSistema;

	@Column(name = "MODULO_NOMBRE", nullable = false, length = 45)
	private String moduloNombre;

	// bi-directional many-to-one association to TbAppEmpresa
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMP_ID", nullable = false)
	private TbAppEmpresa tbAppEmpresa1;

	public TbModulo() {
	}

	public String getModuloId() {
		return this.moduloId;
	}

	public void setModuloId(String moduloId) {
		this.moduloId = moduloId;
	}

	public Date getModuloFechaFinMes() {
		return this.moduloFechaFinMes;
	}

	public void setModuloFechaFinMes(Date moduloFechaFinMes) {
		this.moduloFechaFinMes = moduloFechaFinMes;
	}

	public Date getModuloFechaSistema() {
		return this.moduloFechaSistema;
	}

	public void setModuloFechaSistema(Date moduloFechaSistema) {
		this.moduloFechaSistema = moduloFechaSistema;
	}

	public String getModuloNombre() {
		return this.moduloNombre;
	}

	public void setModuloNombre(String moduloNombre) {
		this.moduloNombre = moduloNombre;
	}

	public TbAppEmpresa getTbAppEmpresa1() {
		return this.tbAppEmpresa1;
	}

	public void setTbAppEmpresa1(TbAppEmpresa tbAppEmpresa1) {
		this.tbAppEmpresa1 = tbAppEmpresa1;
	}

}