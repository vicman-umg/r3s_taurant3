package com.pos.restaurante.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the tb_app_empresa database table.
 * 
 */
@Entity
@Table(name = "tb_app_empresa")
@NamedQuery(name = "TbAppEmpresa.findAll", query = "SELECT t FROM TbAppEmpresa t")
public class TbAppEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_ID", unique = true, nullable = false)
	private Long empId;

	@Column(name = "EMP_DIRECCION", nullable = false, length = 255)
	private String empDireccion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EMP_FECHA_INGRESO", nullable = false)
	private Date empFechaIngreso;

	@Column(name = "EMP_NOMBRE", nullable = false, length = 255)
	private String empNombre;

	@Column(name = "EMP_NOMBRE_ABREVIADO", nullable = false, length = 150)
	private String empNombreAbreviado;

	@Column(name = "EMP_REPRESENTANTE_LEGAL", nullable = false, length = 255)
	private String empRepresentanteLegal;

	// bi-directional many-to-one association to TbModulo
	@OneToMany(mappedBy = "tbAppEmpresa1")
	private List<TbModulo> tbModulos1;

	// bi-directional many-to-one association to TbSucursal
	@OneToMany(mappedBy = "tbAppEmpresa1")
	private List<TbSucursal> tbSucursals1;

	public TbAppEmpresa() {
	}

	public Long getEmpId() {
		return this.empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpDireccion() {
		return this.empDireccion;
	}

	public void setEmpDireccion(String empDireccion) {
		this.empDireccion = empDireccion;
	}

	public Date getEmpFechaIngreso() {
		return this.empFechaIngreso;
	}

	public void setEmpFechaIngreso(Date empFechaIngreso) {
		this.empFechaIngreso = empFechaIngreso;
	}

	public String getEmpNombre() {
		return this.empNombre;
	}

	public void setEmpNombre(String empNombre) {
		this.empNombre = empNombre;
	}

	public String getEmpNombreAbreviado() {
		return this.empNombreAbreviado;
	}

	public void setEmpNombreAbreviado(String empNombreAbreviado) {
		this.empNombreAbreviado = empNombreAbreviado;
	}

	public String getEmpRepresentanteLegal() {
		return this.empRepresentanteLegal;
	}

	public void setEmpRepresentanteLegal(String empRepresentanteLegal) {
		this.empRepresentanteLegal = empRepresentanteLegal;
	}

	public List<TbModulo> getTbModulos1() {
		return this.tbModulos1;
	}

	public void setTbModulos1(List<TbModulo> tbModulos1) {
		this.tbModulos1 = tbModulos1;
	}

	public TbModulo addTbModulos1(TbModulo tbModulos1) {
		getTbModulos1().add(tbModulos1);
		tbModulos1.setTbAppEmpresa1(this);

		return tbModulos1;
	}

	public TbModulo removeTbModulos1(TbModulo tbModulos1) {
		getTbModulos1().remove(tbModulos1);
		tbModulos1.setTbAppEmpresa1(null);

		return tbModulos1;
	}

	public List<TbSucursal> getTbSucursals1() {
		return this.tbSucursals1;
	}

	public void setTbSucursals1(List<TbSucursal> tbSucursals1) {
		this.tbSucursals1 = tbSucursals1;
	}

	public TbSucursal addTbSucursals1(TbSucursal tbSucursals1) {
		getTbSucursals1().add(tbSucursals1);
		tbSucursals1.setTbAppEmpresa1(this);

		return tbSucursals1;
	}

	public TbSucursal removeTbSucursals1(TbSucursal tbSucursals1) {
		getTbSucursals1().remove(tbSucursals1);
		tbSucursals1.setTbAppEmpresa1(null);

		return tbSucursals1;
	}

}