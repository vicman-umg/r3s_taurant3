package com.pos.restaurante.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_tipo_alimento database table.
 * 
 */
@Entity
@Table(name="tb_tipo_alimento")
@NamedQuery(name="TbTipoAlimento.findAll", query="SELECT t FROM TbTipoAlimento t")
public class TbTipoAlimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ALI_ID", unique=true, nullable=false)
	private Long aliId;

	@Column(name="ALI_NOMBRE", nullable=false, length=45)
	private String aliNombre;

	//bi-directional many-to-one association to TbDetalleMenu
	@OneToMany(mappedBy="tbTipoAlimento1")
	private List<TbDetalleMenu> tbDetalleMenus1;

	public TbTipoAlimento() {
	}

	public Long getAliId() {
		return this.aliId;
	}

	public void setAliId(Long aliId) {
		this.aliId = aliId;
	}

	public String getAliNombre() {
		return this.aliNombre;
	}

	public void setAliNombre(String aliNombre) {
		this.aliNombre = aliNombre;
	}

	public List<TbDetalleMenu> getTbDetalleMenus1() {
		return this.tbDetalleMenus1;
	}

	public void setTbDetalleMenus1(List<TbDetalleMenu> tbDetalleMenus1) {
		this.tbDetalleMenus1 = tbDetalleMenus1;
	}

	public TbDetalleMenu addTbDetalleMenus1(TbDetalleMenu tbDetalleMenus1) {
		getTbDetalleMenus1().add(tbDetalleMenus1);
		tbDetalleMenus1.setTbTipoAlimento1(this);

		return tbDetalleMenus1;
	}

	public TbDetalleMenu removeTbDetalleMenus1(TbDetalleMenu tbDetalleMenus1) {
		getTbDetalleMenus1().remove(tbDetalleMenus1);
		tbDetalleMenus1.setTbTipoAlimento1(null);

		return tbDetalleMenus1;
	}

}