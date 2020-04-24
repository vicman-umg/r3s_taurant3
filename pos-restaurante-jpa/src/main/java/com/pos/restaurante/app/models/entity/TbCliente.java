package com.pos.restaurante.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tb_cliente database table.
 * 
 */
@Entity
@Table(name = "tb_cliente")
@NamedQuery(name = "TbCliente.findAll", query = "SELECT t FROM TbCliente t")
public class TbCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLI_ID", unique = true, nullable = false)
	private Long cliId;

	@Column(name = "CLI_CORREO", length = 100)
	private String cliCorreo;

	@Column(name = "CLI_DIRECCION", length = 255)
	private String cliDireccion;

	@Column(name = "CLI_NIT", nullable = false, length = 45)
	private String cliNit;

	@Column(name = "CLI_NOMBRE", nullable = false, length = 255)
	private String cliNombre;

	@Column(name = "CLI_TELEFONO", length = 15)
	private String cliTelefono;

	// bi-directional many-to-one association to TbMovimiento
	@OneToMany(mappedBy = "tbCliente1")
	private List<TbMovimiento> tbMovimientos1;

	public TbCliente() {
	}

	public Long getCliId() {
		return this.cliId;
	}

	public void setCliId(Long cliId) {
		this.cliId = cliId;
	}

	public String getCliCorreo() {
		return this.cliCorreo;
	}

	public void setCliCorreo(String cliCorreo) {
		this.cliCorreo = cliCorreo;
	}

	public String getCliDireccion() {
		return this.cliDireccion;
	}

	public void setCliDireccion(String cliDireccion) {
		this.cliDireccion = cliDireccion;
	}

	public String getCliNit() {
		return this.cliNit;
	}

	public void setCliNit(String cliNit) {
		this.cliNit = cliNit;
	}

	public String getCliNombre() {
		return this.cliNombre;
	}

	public void setCliNombre(String cliNombre) {
		this.cliNombre = cliNombre;
	}

	public String getCliTelefono() {
		return this.cliTelefono;
	}

	public void setCliTelefono(String cliTelefono) {
		this.cliTelefono = cliTelefono;
	}

	public List<TbMovimiento> getTbMovimientos1() {
		return this.tbMovimientos1;
	}

	public void setTbMovimientos1(List<TbMovimiento> tbMovimientos1) {
		this.tbMovimientos1 = tbMovimientos1;
	}

	public TbMovimiento addTbMovimientos1(TbMovimiento tbMovimientos1) {
		getTbMovimientos1().add(tbMovimientos1);
		tbMovimientos1.setTbCliente1(this);

		return tbMovimientos1;
	}

	public TbMovimiento removeTbMovimientos1(TbMovimiento tbMovimientos1) {
		getTbMovimientos1().remove(tbMovimientos1);
		tbMovimientos1.setTbCliente1(null);

		return tbMovimientos1;
	}

}