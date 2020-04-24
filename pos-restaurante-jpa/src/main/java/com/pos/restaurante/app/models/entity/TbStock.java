package com.pos.restaurante.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the tb_stock database table.
 * 
 */
@Entity
@Table(name="tb_stock")
@NamedQuery(name="TbStock.findAll", query="SELECT t FROM TbStock t")
public class TbStock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STK_ID", unique=true, nullable=false)
	private Long stkId;

	@Column(name="STK_CANTIDAD")
	private int stkCantidad;

	@Column(name="STK_PESO_KILO", precision=10, scale=2)
	private BigDecimal stkPesoKilo;

	@Column(name="STK_PESO_LIBRA", precision=10, scale=2)
	private BigDecimal stkPesoLibra;

	@Column(name="STK_PRECIO", nullable=false, precision=10, scale=2)
	private BigDecimal stkPrecio;

	@Temporal(TemporalType.DATE)
	@Column(name="STK_ULTIMO_IINGRESO")
	private Date stkUltimoIingreso;

	//bi-directional many-to-one association to TbProducto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PROD_ID", nullable=false)
	private TbProducto tbProducto1;

	//bi-directional many-to-one association to TbProveedor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PROV_ID", nullable=false)
	private TbProveedor tbProveedor1;


	//bi-directional many-to-one association to TbSucursal
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SUC_ID", nullable=false)
	private TbSucursal tbSucursal1;


	public TbStock() {
	}

	public Long getStkId() {
		return this.stkId;
	}

	public void setStkId(Long stkId) {
		this.stkId = stkId;
	}

	public int getStkCantidad() {
		return this.stkCantidad;
	}

	public void setStkCantidad(int stkCantidad) {
		this.stkCantidad = stkCantidad;
	}

	public BigDecimal getStkPesoKilo() {
		return this.stkPesoKilo;
	}

	public void setStkPesoKilo(BigDecimal stkPesoKilo) {
		this.stkPesoKilo = stkPesoKilo;
	}

	public BigDecimal getStkPesoLibra() {
		return this.stkPesoLibra;
	}

	public void setStkPesoLibra(BigDecimal stkPesoLibra) {
		this.stkPesoLibra = stkPesoLibra;
	}

	public BigDecimal getStkPrecio() {
		return this.stkPrecio;
	}

	public void setStkPrecio(BigDecimal stkPrecio) {
		this.stkPrecio = stkPrecio;
	}

	public Date getStkUltimoIingreso() {
		return this.stkUltimoIingreso;
	}

	public void setStkUltimoIingreso(Date stkUltimoIingreso) {
		this.stkUltimoIingreso = stkUltimoIingreso;
	}

	public TbProducto getTbProducto1() {
		return this.tbProducto1;
	}

	public void setTbProducto1(TbProducto tbProducto1) {
		this.tbProducto1 = tbProducto1;
	}


	public TbProveedor getTbProveedor1() {
		return this.tbProveedor1;
	}

	public void setTbProveedor1(TbProveedor tbProveedor1) {
		this.tbProveedor1 = tbProveedor1;
	}


	public TbSucursal getTbSucursal1() {
		return this.tbSucursal1;
	}

	public void setTbSucursal1(TbSucursal tbSucursal1) {
		this.tbSucursal1 = tbSucursal1;
	}

}