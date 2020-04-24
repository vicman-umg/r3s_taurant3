package com.pos.restaurante.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_app_permiso database table.
 * 
 */
@Entity
@Table(name="tb_app_permiso")
@NamedQuery(name="TbAppPermiso.findAll", query="SELECT t FROM TbAppPermiso t")
public class TbAppPermiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PER_ID", unique=true, nullable=false)
	private Long perId;

	@Column(name="PER_DESCRIPCION", nullable=false, length=255)
	private String perDescripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="PER_FECHA_INGRESO", nullable=false)
	private Date perFechaIngreso;

	@Column(name="PER_NOMBRE", nullable=false, length=100)
	private String perNombre;

	//bi-directional many-to-one association to TbAppPermisoRol
	@OneToMany(mappedBy="tbAppPermiso1")
	private List<TbAppPermisoRol> tbAppPermisoRols1;


	public TbAppPermiso() {
	}

	public Long getPerId() {
		return this.perId;
	}

	public void setPerId(Long perId) {
		this.perId = perId;
	}

	public String getPerDescripcion() {
		return this.perDescripcion;
	}

	public void setPerDescripcion(String perDescripcion) {
		this.perDescripcion = perDescripcion;
	}

	public Date getPerFechaIngreso() {
		return this.perFechaIngreso;
	}

	public void setPerFechaIngreso(Date perFechaIngreso) {
		this.perFechaIngreso = perFechaIngreso;
	}

	public String getPerNombre() {
		return this.perNombre;
	}

	public void setPerNombre(String perNombre) {
		this.perNombre = perNombre;
	}

	public List<TbAppPermisoRol> getTbAppPermisoRols1() {
		return this.tbAppPermisoRols1;
	}

	public void setTbAppPermisoRols1(List<TbAppPermisoRol> tbAppPermisoRols1) {
		this.tbAppPermisoRols1 = tbAppPermisoRols1;
	}

	public TbAppPermisoRol addTbAppPermisoRols1(TbAppPermisoRol tbAppPermisoRols1) {
		getTbAppPermisoRols1().add(tbAppPermisoRols1);
		tbAppPermisoRols1.setTbAppPermiso1(this);

		return tbAppPermisoRols1;
	}

	public TbAppPermisoRol removeTbAppPermisoRols1(TbAppPermisoRol tbAppPermisoRols1) {
		getTbAppPermisoRols1().remove(tbAppPermisoRols1);
		tbAppPermisoRols1.setTbAppPermiso1(null);

		return tbAppPermisoRols1;
	}


}