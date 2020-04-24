package com.pos.restaurante.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_app_rol database table.
 * 
 */
@Entity
@Table(name="tb_app_rol")
@NamedQuery(name="TbAppRol.findAll", query="SELECT t FROM TbAppRol t")
public class TbAppRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ROL_ID", unique=true, nullable=false)
	private Long rolId;

	@Column(name="ROL_DESCRIPCION", nullable=false, length=255)
	private String rolDescripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="ROL_FECHA_INGRESO", nullable=false)
	private Date rolFechaIngreso;

	@Column(name="ROL_NOMBRE", nullable=false, length=100)
	private String rolNombre;

	//bi-directional many-to-one association to TbAppPermisoRol
	@OneToMany(mappedBy="tbAppRol1")
	private List<TbAppPermisoRol> tbAppPermisoRols1;

	//bi-directional many-to-one association to TbRolUsuario
	@OneToMany(mappedBy="tbAppRol")
	private List<TbRolUsuario> tbRolUsuarios;

	public TbAppRol() {
	}

	public Long getRolId() {
		return this.rolId;
	}

	public void setRolId(Long rolId) {
		this.rolId = rolId;
	}

	public String getRolDescripcion() {
		return this.rolDescripcion;
	}

	public void setRolDescripcion(String rolDescripcion) {
		this.rolDescripcion = rolDescripcion;
	}

	public Date getRolFechaIngreso() {
		return this.rolFechaIngreso;
	}

	public void setRolFechaIngreso(Date rolFechaIngreso) {
		this.rolFechaIngreso = rolFechaIngreso;
	}

	public String getRolNombre() {
		return this.rolNombre;
	}

	public void setRolNombre(String rolNombre) {
		this.rolNombre = rolNombre;
	}

	public List<TbAppPermisoRol> getTbAppPermisoRols1() {
		return this.tbAppPermisoRols1;
	}

	public void setTbAppPermisoRols1(List<TbAppPermisoRol> tbAppPermisoRols1) {
		this.tbAppPermisoRols1 = tbAppPermisoRols1;
	}

	public TbAppPermisoRol addTbAppPermisoRols1(TbAppPermisoRol tbAppPermisoRols1) {
		getTbAppPermisoRols1().add(tbAppPermisoRols1);
		tbAppPermisoRols1.setTbAppRol1(this);

		return tbAppPermisoRols1;
	}

	public TbAppPermisoRol removeTbAppPermisoRols1(TbAppPermisoRol tbAppPermisoRols1) {
		getTbAppPermisoRols1().remove(tbAppPermisoRols1);
		tbAppPermisoRols1.setTbAppRol1(null);

		return tbAppPermisoRols1;
	}

	public List<TbRolUsuario> getTbRolUsuarios() {
		return this.tbRolUsuarios;
	}

	public void setTbRolUsuarios(List<TbRolUsuario> tbRolUsuarios) {
		this.tbRolUsuarios = tbRolUsuarios;
	}

	public TbRolUsuario addTbRolUsuario(TbRolUsuario tbRolUsuario) {
		getTbRolUsuarios().add(tbRolUsuario);
		tbRolUsuario.setTbAppRol(this);

		return tbRolUsuario;
	}

	public TbRolUsuario removeTbRolUsuario(TbRolUsuario tbRolUsuario) {
		getTbRolUsuarios().remove(tbRolUsuario);
		tbRolUsuario.setTbAppRol(null);

		return tbRolUsuario;
	}

}