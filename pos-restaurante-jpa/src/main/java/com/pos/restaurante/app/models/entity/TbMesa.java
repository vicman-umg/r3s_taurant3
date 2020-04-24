package com.pos.restaurante.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_mesa database table.
 * 
 */
@Entity
@Table(name="tb_mesa")
@NamedQuery(name="TbMesa.findAll", query="SELECT t FROM TbMesa t")
public class TbMesa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_MESA", unique=true, nullable=false)
	private Long idMesa;

	@Column(name="MESA_NOMBRE", nullable=false, length=45)
	private String mesaNombre;

	@Column(name="MESA_NUMERO", nullable=false)
	private int mesaNumero;

	//bi-directional many-to-one association to TbSucursal
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SUC_ID", nullable=false)
	private TbSucursal tbSucursal1;


	//bi-directional many-to-one association to TbMovimiento
	@OneToMany(mappedBy="tbMesa1")
	private List<TbMovimiento> tbMovimientos1;

	public TbMesa() {
	}

	public Long getIdMesa() {
		return this.idMesa;
	}

	public void setIdMesa(Long idMesa) {
		this.idMesa = idMesa;
	}

	public String getMesaNombre() {
		return this.mesaNombre;
	}

	public void setMesaNombre(String mesaNombre) {
		this.mesaNombre = mesaNombre;
	}

	public int getMesaNumero() {
		return this.mesaNumero;
	}

	public void setMesaNumero(int mesaNumero) {
		this.mesaNumero = mesaNumero;
	}

	public TbSucursal getTbSucursal1() {
		return this.tbSucursal1;
	}

	public void setTbSucursal1(TbSucursal tbSucursal1) {
		this.tbSucursal1 = tbSucursal1;
	}


	public List<TbMovimiento> getTbMovimientos1() {
		return this.tbMovimientos1;
	}

	public void setTbMovimientos1(List<TbMovimiento> tbMovimientos1) {
		this.tbMovimientos1 = tbMovimientos1;
	}

	public TbMovimiento addTbMovimientos1(TbMovimiento tbMovimientos1) {
		getTbMovimientos1().add(tbMovimientos1);
		tbMovimientos1.setTbMesa1(this);

		return tbMovimientos1;
	}

	public TbMovimiento removeTbMovimientos1(TbMovimiento tbMovimientos1) {
		getTbMovimientos1().remove(tbMovimientos1);
		tbMovimientos1.setTbMesa1(null);

		return tbMovimientos1;
	}

}