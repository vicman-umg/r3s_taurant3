package com.pos.restaurante.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_app_permiso_rol database table.
 * 
 */
@Entity
@Table(name="tb_app_permiso_rol")
@NamedQuery(name="TbAppPermisoRol.findAll", query="SELECT t FROM TbAppPermisoRol t")
public class TbAppPermisoRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PERMISO_ASIGNADO", unique=true, nullable=false)
	private Long idPermisoAsignado;

	@Column(name="ESTADO_PERMISO", nullable=false)
	private int estadoPermiso;

	//bi-directional many-to-one association to TbAppPermiso
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PER_ID", nullable=false)
	private TbAppPermiso tbAppPermiso1;


	//bi-directional many-to-one association to TbAppRol
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ROL_ID", nullable=false)
	private TbAppRol tbAppRol1;


	public TbAppPermisoRol() {
	}

	public Long getIdPermisoAsignado() {
		return this.idPermisoAsignado;
	}

	public void setIdPermisoAsignado(Long idPermisoAsignado) {
		this.idPermisoAsignado = idPermisoAsignado;
	}

	public int getEstadoPermiso() {
		return this.estadoPermiso;
	}

	public void setEstadoPermiso(int estadoPermiso) {
		this.estadoPermiso = estadoPermiso;
	}

	public TbAppPermiso getTbAppPermiso1() {
		return this.tbAppPermiso1;
	}

	public void setTbAppPermiso1(TbAppPermiso tbAppPermiso1) {
		this.tbAppPermiso1 = tbAppPermiso1;
	}


	public TbAppRol getTbAppRol1() {
		return this.tbAppRol1;
	}

	public void setTbAppRol1(TbAppRol tbAppRol1) {
		this.tbAppRol1 = tbAppRol1;
	}


}