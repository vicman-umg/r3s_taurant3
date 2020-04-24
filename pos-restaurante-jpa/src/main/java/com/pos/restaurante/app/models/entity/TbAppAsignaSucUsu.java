package com.pos.restaurante.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the tb_app_asigna_suc_usu database table.
 * 
 */
@Entity
@Table(name = "tb_app_asigna_suc_usu")
@NamedQuery(name = "TbAppAsignaSucUsu.findAll", query = "SELECT t FROM TbAppAsignaSucUsu t")
public class TbAppAsignaSucUsu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUC_ASIGNA_ID", unique = true, nullable = false)
	private Long sucAsignaId;

	// bi-directional many-to-one association to TbSucursal
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUC_ID", nullable = false)
	private TbSucursal tbSucursal1;

	// bi-directional many-to-one association to TbUsuario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USU_ID", nullable = false)
	private TbUsuario tbUsuario1;

	public TbAppAsignaSucUsu() {
	}

	public Long getSucAsignaId() {
		return this.sucAsignaId;
	}

	public void setSucAsignaId(Long sucAsignaId) {
		this.sucAsignaId = sucAsignaId;
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