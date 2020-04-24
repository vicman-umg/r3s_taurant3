package com.pos.restaurante.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_rol_usuario database table.
 * 
 */
@Entity
@Table(name="tb_rol_usuario")
@NamedQuery(name="TbRolUsuario.findAll", query="SELECT t FROM TbRolUsuario t")
public class TbRolUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AROL_ID", unique=true, nullable=false)
	private Long arolId;

	//bi-directional many-to-one association to TbAppRol
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ROL_ID", nullable=false)
	private TbAppRol tbAppRol;

	//bi-directional many-to-one association to TbUsuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USU_ID", nullable=false)
	private TbUsuario tbUsuario;

	public TbRolUsuario() {
	}

	public Long getArolId() {
		return this.arolId;
	}

	public void setArolId(Long arolId) {
		this.arolId = arolId;
	}

	public TbAppRol getTbAppRol() {
		return this.tbAppRol;
	}

	public void setTbAppRol(TbAppRol tbAppRol) {
		this.tbAppRol = tbAppRol;
	}

	public TbUsuario getTbUsuario() {
		return this.tbUsuario;
	}

	public void setTbUsuario(TbUsuario tbUsuario) {
		this.tbUsuario = tbUsuario;
	}

}