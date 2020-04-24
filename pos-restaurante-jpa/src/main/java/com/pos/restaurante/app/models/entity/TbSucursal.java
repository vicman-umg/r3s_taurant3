package com.pos.restaurante.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the tb_sucursal database table.
 * 
 */
@Entity
@Table(name = "tb_sucursal")
@NamedQuery(name = "TbSucursal.findAll", query = "SELECT t FROM TbSucursal t")
public class TbSucursal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUC_ID", unique = true, nullable = false)
	private Long sucId;

	@Column(name = "SUC_DIRECCION", nullable = false, length = 255)
	private String sucDireccion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SUC_FECHA_INGRESO", nullable = false)
	private Date sucFechaIngreso;

	@Column(name = "SUC_GERENTE", nullable = false, length = 255)
	private String sucGerente;

	@Column(name = "SUC_NOMBRE", nullable = false, length = 255)
	private String sucNombre;

	@Column(name = "SUC_NOMBRE_ABREVIADO", nullable = false, length = 150)
	private String sucNombreAbreviado;

	@Column(name = "SUC_TELEFONO", nullable = false, length = 15)
	private String sucTelefono;

	// bi-directional many-to-one association to TbAperturaCaja
	@OneToMany(mappedBy = "tbSucursal1")
	private List<TbAperturaCaja> tbAperturaCajas1;

	// bi-directional many-to-one association to TbAppAsignaSucUsu
	@OneToMany(mappedBy = "tbSucursal1")
	private List<TbAppAsignaSucUsu> tbAppAsignaSucUsus1;

	// bi-directional many-to-one association to TbMesa
	@OneToMany(mappedBy = "tbSucursal1")
	private List<TbMesa> tbMesas1;

	// bi-directional many-to-one association to TbMovimiento
	@OneToMany(mappedBy = "tbSucursal1")
	private List<TbMovimiento> tbMovimientos1;

	// bi-directional many-to-one association to TbStock
	@OneToMany(mappedBy = "tbSucursal1")
	private List<TbStock> tbStocks1;

	// bi-directional many-to-one association to TbAppEmpresa
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUC_EMP_ID", nullable = false)
	private TbAppEmpresa tbAppEmpresa1;

	public TbSucursal() {
	}

	public Long getSucId() {
		return this.sucId;
	}

	public void setSucId(Long sucId) {
		this.sucId = sucId;
	}

	public String getSucDireccion() {
		return this.sucDireccion;
	}

	public void setSucDireccion(String sucDireccion) {
		this.sucDireccion = sucDireccion;
	}

	public Date getSucFechaIngreso() {
		return this.sucFechaIngreso;
	}

	public void setSucFechaIngreso(Date sucFechaIngreso) {
		this.sucFechaIngreso = sucFechaIngreso;
	}

	public String getSucGerente() {
		return this.sucGerente;
	}

	public void setSucGerente(String sucGerente) {
		this.sucGerente = sucGerente;
	}

	public String getSucNombre() {
		return this.sucNombre;
	}

	public void setSucNombre(String sucNombre) {
		this.sucNombre = sucNombre;
	}

	public String getSucNombreAbreviado() {
		return this.sucNombreAbreviado;
	}

	public void setSucNombreAbreviado(String sucNombreAbreviado) {
		this.sucNombreAbreviado = sucNombreAbreviado;
	}

	public String getSucTelefono() {
		return this.sucTelefono;
	}

	public void setSucTelefono(String sucTelefono) {
		this.sucTelefono = sucTelefono;
	}

	public List<TbAperturaCaja> getTbAperturaCajas1() {
		return this.tbAperturaCajas1;
	}

	public void setTbAperturaCajas1(List<TbAperturaCaja> tbAperturaCajas1) {
		this.tbAperturaCajas1 = tbAperturaCajas1;
	}

	public TbAperturaCaja addTbAperturaCajas1(TbAperturaCaja tbAperturaCajas1) {
		getTbAperturaCajas1().add(tbAperturaCajas1);
		tbAperturaCajas1.setTbSucursal1(this);

		return tbAperturaCajas1;
	}

	public TbAperturaCaja removeTbAperturaCajas1(TbAperturaCaja tbAperturaCajas1) {
		getTbAperturaCajas1().remove(tbAperturaCajas1);
		tbAperturaCajas1.setTbSucursal1(null);

		return tbAperturaCajas1;
	}

	public List<TbAppAsignaSucUsu> getTbAppAsignaSucUsus1() {
		return this.tbAppAsignaSucUsus1;
	}

	public void setTbAppAsignaSucUsus1(List<TbAppAsignaSucUsu> tbAppAsignaSucUsus1) {
		this.tbAppAsignaSucUsus1 = tbAppAsignaSucUsus1;
	}

	public TbAppAsignaSucUsu addTbAppAsignaSucUsus1(TbAppAsignaSucUsu tbAppAsignaSucUsus1) {
		getTbAppAsignaSucUsus1().add(tbAppAsignaSucUsus1);
		tbAppAsignaSucUsus1.setTbSucursal1(this);

		return tbAppAsignaSucUsus1;
	}

	public TbAppAsignaSucUsu removeTbAppAsignaSucUsus1(TbAppAsignaSucUsu tbAppAsignaSucUsus1) {
		getTbAppAsignaSucUsus1().remove(tbAppAsignaSucUsus1);
		tbAppAsignaSucUsus1.setTbSucursal1(null);

		return tbAppAsignaSucUsus1;
	}

	public List<TbMesa> getTbMesas1() {
		return this.tbMesas1;
	}

	public void setTbMesas1(List<TbMesa> tbMesas1) {
		this.tbMesas1 = tbMesas1;
	}

	public TbMesa addTbMesas1(TbMesa tbMesas1) {
		getTbMesas1().add(tbMesas1);
		tbMesas1.setTbSucursal1(this);

		return tbMesas1;
	}

	public TbMesa removeTbMesas1(TbMesa tbMesas1) {
		getTbMesas1().remove(tbMesas1);
		tbMesas1.setTbSucursal1(null);

		return tbMesas1;
	}

	public List<TbMovimiento> getTbMovimientos1() {
		return this.tbMovimientos1;
	}

	public void setTbMovimientos1(List<TbMovimiento> tbMovimientos1) {
		this.tbMovimientos1 = tbMovimientos1;
	}

	public TbMovimiento addTbMovimientos1(TbMovimiento tbMovimientos1) {
		getTbMovimientos1().add(tbMovimientos1);
		tbMovimientos1.setTbSucursal1(this);

		return tbMovimientos1;
	}

	public TbMovimiento removeTbMovimientos1(TbMovimiento tbMovimientos1) {
		getTbMovimientos1().remove(tbMovimientos1);
		tbMovimientos1.setTbSucursal1(null);

		return tbMovimientos1;
	}

	public List<TbStock> getTbStocks1() {
		return this.tbStocks1;
	}

	public void setTbStocks1(List<TbStock> tbStocks1) {
		this.tbStocks1 = tbStocks1;
	}

	public TbStock addTbStocks1(TbStock tbStocks1) {
		getTbStocks1().add(tbStocks1);
		tbStocks1.setTbSucursal1(this);

		return tbStocks1;
	}

	public TbStock removeTbStocks1(TbStock tbStocks1) {
		getTbStocks1().remove(tbStocks1);
		tbStocks1.setTbSucursal1(null);

		return tbStocks1;
	}

	public TbAppEmpresa getTbAppEmpresa1() {
		return this.tbAppEmpresa1;
	}

	public void setTbAppEmpresa1(TbAppEmpresa tbAppEmpresa1) {
		this.tbAppEmpresa1 = tbAppEmpresa1;
	}

}