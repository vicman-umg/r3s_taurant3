package com.pos.restaurante.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the tb_movimiento database table.
 * 
 */
@Entity
@Table(name = "tb_movimiento")
@NamedQuery(name = "TbMovimiento.findAll", query = "SELECT t FROM TbMovimiento t")
public class TbMovimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOV_ID", unique = true, nullable = false)
	private Long movId;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_SISTEMA", nullable = false)
	private Date fechaSistema;

	@Column(name = "MOV_CANTIDAD", nullable = false, length = 45)
	private String movCantidad;

	@Column(name = "MOV_ESTADO", nullable = false, length = 1)
	private String movEstado;

	@Temporal(TemporalType.DATE)
	@Column(name = "MOV_FECHA", nullable = false)
	private Date movFecha;

	@Column(name = "MOV_HORA", nullable = false, length = 20)
	private String movHora;

	@Column(name = "MOV_MONTO", nullable = false, precision = 10, scale = 2)
	private BigDecimal movMonto;

	@Column(name = "MOV_NUM_AUTORIZA", nullable = false)
	private int movNumAutoriza;

	@Column(name = "MOV_NUM_DOC", nullable = false, length = 45)
	private String movNumDoc;

	@Column(name = "MOV_REFERENCIA", length = 45)
	private String movReferencia;

	// bi-directional many-to-one association to TbDetalleMovimiento
	@OneToMany(mappedBy = "tbMovimiento1")
	private List<TbDetalleMovimiento> tbDetalleMovimientos1;

	// bi-directional many-to-one association to TbAppTipoMovimiento
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_MOV", nullable = false)
	private TbAppTipoMovimiento tbAppTipoMovimiento1;

	// bi-directional many-to-one association to TbAppTipoPago
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_PAGO_ID", nullable = false)
	private TbAppTipoPago tbAppTipoPago1;

	// bi-directional many-to-one association to TbCliente
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLI_ID")
	private TbCliente tbCliente1;

	// bi-directional many-to-one association to TbMesa
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MESA", nullable = false)
	private TbMesa tbMesa1;

	// bi-directional many-to-one association to TbSucursal
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUC_ID", nullable = false)
	private TbSucursal tbSucursal1;

	// bi-directional many-to-one association to TbUsuario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USU_ID", nullable = false)
	private TbUsuario tbUsuario1;

	public TbMovimiento() {
	}

	public Long getMovId() {
		return this.movId;
	}

	public void setMovId(Long movId) {
		this.movId = movId;
	}

	public Date getFechaSistema() {
		return this.fechaSistema;
	}

	public void setFechaSistema(Date fechaSistema) {
		this.fechaSistema = fechaSistema;
	}

	public String getMovCantidad() {
		return this.movCantidad;
	}

	public void setMovCantidad(String movCantidad) {
		this.movCantidad = movCantidad;
	}

	public String getMovEstado() {
		return this.movEstado;
	}

	public void setMovEstado(String movEstado) {
		this.movEstado = movEstado;
	}

	public Date getMovFecha() {
		return this.movFecha;
	}

	public void setMovFecha(Date movFecha) {
		this.movFecha = movFecha;
	}

	public String getMovHora() {
		return this.movHora;
	}

	public void setMovHora(String movHora) {
		this.movHora = movHora;
	}

	public BigDecimal getMovMonto() {
		return this.movMonto;
	}

	public void setMovMonto(BigDecimal movMonto) {
		this.movMonto = movMonto;
	}

	public int getMovNumAutoriza() {
		return this.movNumAutoriza;
	}

	public void setMovNumAutoriza(int movNumAutoriza) {
		this.movNumAutoriza = movNumAutoriza;
	}

	public String getMovNumDoc() {
		return this.movNumDoc;
	}

	public void setMovNumDoc(String movNumDoc) {
		this.movNumDoc = movNumDoc;
	}

	public String getMovReferencia() {
		return this.movReferencia;
	}

	public void setMovReferencia(String movReferencia) {
		this.movReferencia = movReferencia;
	}

	public List<TbDetalleMovimiento> getTbDetalleMovimientos1() {
		return this.tbDetalleMovimientos1;
	}

	public void setTbDetalleMovimientos1(List<TbDetalleMovimiento> tbDetalleMovimientos1) {
		this.tbDetalleMovimientos1 = tbDetalleMovimientos1;
	}

	public TbDetalleMovimiento addTbDetalleMovimientos1(TbDetalleMovimiento tbDetalleMovimientos1) {
		getTbDetalleMovimientos1().add(tbDetalleMovimientos1);
		tbDetalleMovimientos1.setTbMovimiento1(this);

		return tbDetalleMovimientos1;
	}

	public TbDetalleMovimiento removeTbDetalleMovimientos1(TbDetalleMovimiento tbDetalleMovimientos1) {
		getTbDetalleMovimientos1().remove(tbDetalleMovimientos1);
		tbDetalleMovimientos1.setTbMovimiento1(null);

		return tbDetalleMovimientos1;
	}

	public TbAppTipoMovimiento getTbAppTipoMovimiento1() {
		return this.tbAppTipoMovimiento1;
	}

	public void setTbAppTipoMovimiento1(TbAppTipoMovimiento tbAppTipoMovimiento1) {
		this.tbAppTipoMovimiento1 = tbAppTipoMovimiento1;
	}

	public TbAppTipoPago getTbAppTipoPago1() {
		return this.tbAppTipoPago1;
	}

	public void setTbAppTipoPago1(TbAppTipoPago tbAppTipoPago1) {
		this.tbAppTipoPago1 = tbAppTipoPago1;
	}

	public TbCliente getTbCliente1() {
		return this.tbCliente1;
	}

	public void setTbCliente1(TbCliente tbCliente1) {
		this.tbCliente1 = tbCliente1;
	}

	public TbMesa getTbMesa1() {
		return this.tbMesa1;
	}

	public void setTbMesa1(TbMesa tbMesa1) {
		this.tbMesa1 = tbMesa1;
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