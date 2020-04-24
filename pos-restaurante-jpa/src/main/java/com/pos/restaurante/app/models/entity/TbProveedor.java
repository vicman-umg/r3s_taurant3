package com.pos.restaurante.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_proveedor database table.
 * 
 */
@Entity
@Table(name="tb_proveedor")
@NamedQuery(name="TbProveedor.findAll", query="SELECT t FROM TbProveedor t")
public class TbProveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PROV_ID", unique=true, nullable=false)
	private Long provId;

	@Column(name="PROV_CORREO", length=45)
	private String provCorreo;

	@Column(name="PROV_DIRECCION", length=255)
	private String provDireccion;

	@Column(name="PROV_NIT", length=45)
	private String provNit;

	@Column(name="PROV_NOMBRE", nullable=false, length=255)
	private String provNombre;

	@Column(name="PROV_TELEFONO", length=15)
	private String provTelefono;

	//bi-directional many-to-one association to TbStock
	@OneToMany(mappedBy="tbProveedor1")
	private List<TbStock> tbStocks1;


	public TbProveedor() {
	}

	public Long getProvId() {
		return this.provId;
	}

	public void setProvId(Long provId) {
		this.provId = provId;
	}

	public String getProvCorreo() {
		return this.provCorreo;
	}

	public void setProvCorreo(String provCorreo) {
		this.provCorreo = provCorreo;
	}

	public String getProvDireccion() {
		return this.provDireccion;
	}

	public void setProvDireccion(String provDireccion) {
		this.provDireccion = provDireccion;
	}

	public String getProvNit() {
		return this.provNit;
	}

	public void setProvNit(String provNit) {
		this.provNit = provNit;
	}

	public String getProvNombre() {
		return this.provNombre;
	}

	public void setProvNombre(String provNombre) {
		this.provNombre = provNombre;
	}

	public String getProvTelefono() {
		return this.provTelefono;
	}

	public void setProvTelefono(String provTelefono) {
		this.provTelefono = provTelefono;
	}

	public List<TbStock> getTbStocks1() {
		return this.tbStocks1;
	}

	public void setTbStocks1(List<TbStock> tbStocks1) {
		this.tbStocks1 = tbStocks1;
	}

	public TbStock addTbStocks1(TbStock tbStocks1) {
		getTbStocks1().add(tbStocks1);
		tbStocks1.setTbProveedor1(this);

		return tbStocks1;
	}

	public TbStock removeTbStocks1(TbStock tbStocks1) {
		getTbStocks1().remove(tbStocks1);
		tbStocks1.setTbProveedor1(null);

		return tbStocks1;
	}

}