package com.pos.restaurante.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_producto database table.
 * 
 */
@Entity
@Table(name="tb_producto")
@NamedQuery(name="TbProducto.findAll", query="SELECT t FROM TbProducto t")
public class TbProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PROD_ID", unique=true, nullable=false)
	private Long prodId;

	@Column(name="PROD_COD_BARRA", length=45)
	private String prodCodBarra;

	@Column(name="PROD_IMAGEN", length=45)
	private String prodImagen;

	@Column(name="PROD_NOMBRE", nullable=false, length=255)
	private String prodNombre;

	//bi-directional many-to-one association to TbStock
	@OneToMany(mappedBy="tbProducto1")
	private List<TbStock> tbStocks1;


	public TbProducto() {
	}

	public Long getProdId() {
		return this.prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	public String getProdCodBarra() {
		return this.prodCodBarra;
	}

	public void setProdCodBarra(String prodCodBarra) {
		this.prodCodBarra = prodCodBarra;
	}

	public String getProdImagen() {
		return this.prodImagen;
	}

	public void setProdImagen(String prodImagen) {
		this.prodImagen = prodImagen;
	}

	public String getProdNombre() {
		return this.prodNombre;
	}

	public void setProdNombre(String prodNombre) {
		this.prodNombre = prodNombre;
	}

	public List<TbStock> getTbStocks1() {
		return this.tbStocks1;
	}

	public void setTbStocks1(List<TbStock> tbStocks1) {
		this.tbStocks1 = tbStocks1;
	}

	public TbStock addTbStocks1(TbStock tbStocks1) {
		getTbStocks1().add(tbStocks1);
		tbStocks1.setTbProducto1(this);

		return tbStocks1;
	}

	public TbStock removeTbStocks1(TbStock tbStocks1) {
		getTbStocks1().remove(tbStocks1);
		tbStocks1.setTbProducto1(null);

		return tbStocks1;
	}

}