package com.pos.restaurante.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tb_usuario database table.
 * 
 */
@Entity
@Table(name = "tb_usuario")
@NamedQuery(name = "TbUsuario.findAll", query = "SELECT t FROM TbUsuario t")
public class TbUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USU_ID", unique = true, nullable = false, length = 45)
	private String usuId;

	@Column(name = "FECHA_NACIMIENTO", nullable = false, length = 45)
	private String fechaNacimiento;

	@Column(name = "USU_ENABLED", nullable = false)
	private Boolean usuEnabled;

	@Column(name = "USU_O_NOMBRES", length = 45)
	private String usuONombres;

	@Column(name = "USU_P_APELLIDO", nullable = false, length = 45)
	private String usuPApellido;

	@Column(name = "USU_P_NOMBRE", nullable = false, length = 45)
	private String usuPNombre;

	@Column(name = "USU_PASSWORD", nullable = false, length = 80)
	private String usuPassword;

	@Column(name = "USU_S_NOMBRE", length = 45)
	private String usuSNombre;

	@Column(name = "USU_SEGUNDO_APELLIDO", length = 45)
	private String usuSegundoApellido;

	// bi-directional many-to-one association to TbAperturaCaja
	@OneToMany(mappedBy = "tbUsuario1")
	private List<TbAperturaCaja> tbAperturaCajas1;

	// bi-directional many-to-one association to TbAppAsignaSucUsu
	@OneToMany(mappedBy = "tbUsuario1")
	private List<TbAppAsignaSucUsu> tbAppAsignaSucUsus1;

	// bi-directional many-to-one association to TbMovimiento
	@OneToMany(mappedBy = "tbUsuario1")
	private List<TbMovimiento> tbMovimientos1;

	// bi-directional many-to-one association to TbRolUsuario
	@OneToMany(mappedBy = "tbUsuario")
	private List<TbRolUsuario> tbRolUsuarios;

	public TbUsuario() {
	}

	public String getUsuId() {
		return this.usuId;
	}

	public void setUsuId(String usuId) {
		this.usuId = usuId;
	}

	public String getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Boolean getUsuEnabled() {
		return this.usuEnabled;
	}

	public void setUsuEnabled(Boolean usuEnabled) {
		this.usuEnabled = usuEnabled;
	}

	public String getUsuONombres() {
		return this.usuONombres;
	}

	public void setUsuONombres(String usuONombres) {
		this.usuONombres = usuONombres;
	}

	public String getUsuPApellido() {
		return this.usuPApellido;
	}

	public void setUsuPApellido(String usuPApellido) {
		this.usuPApellido = usuPApellido;
	}

	public String getUsuPNombre() {
		return this.usuPNombre;
	}

	public void setUsuPNombre(String usuPNombre) {
		this.usuPNombre = usuPNombre;
	}

	public String getUsuPassword() {
		return this.usuPassword;
	}

	public void setUsuPassword(String usuPassword) {
		this.usuPassword = usuPassword;
	}

	public String getUsuSNombre() {
		return this.usuSNombre;
	}

	public void setUsuSNombre(String usuSNombre) {
		this.usuSNombre = usuSNombre;
	}

	public String getUsuSegundoApellido() {
		return this.usuSegundoApellido;
	}

	public void setUsuSegundoApellido(String usuSegundoApellido) {
		this.usuSegundoApellido = usuSegundoApellido;
	}

	public List<TbAperturaCaja> getTbAperturaCajas1() {
		return this.tbAperturaCajas1;
	}

	public void setTbAperturaCajas1(List<TbAperturaCaja> tbAperturaCajas1) {
		this.tbAperturaCajas1 = tbAperturaCajas1;
	}

	public TbAperturaCaja addTbAperturaCajas1(TbAperturaCaja tbAperturaCajas1) {
		getTbAperturaCajas1().add(tbAperturaCajas1);
		tbAperturaCajas1.setTbUsuario1(this);

		return tbAperturaCajas1;
	}

	public TbAperturaCaja removeTbAperturaCajas1(TbAperturaCaja tbAperturaCajas1) {
		getTbAperturaCajas1().remove(tbAperturaCajas1);
		tbAperturaCajas1.setTbUsuario1(null);

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
		tbAppAsignaSucUsus1.setTbUsuario1(this);

		return tbAppAsignaSucUsus1;
	}

	public TbAppAsignaSucUsu removeTbAppAsignaSucUsus1(TbAppAsignaSucUsu tbAppAsignaSucUsus1) {
		getTbAppAsignaSucUsus1().remove(tbAppAsignaSucUsus1);
		tbAppAsignaSucUsus1.setTbUsuario1(null);

		return tbAppAsignaSucUsus1;
	}

	public List<TbMovimiento> getTbMovimientos1() {
		return this.tbMovimientos1;
	}

	public void setTbMovimientos1(List<TbMovimiento> tbMovimientos1) {
		this.tbMovimientos1 = tbMovimientos1;
	}

	public TbMovimiento addTbMovimientos1(TbMovimiento tbMovimientos1) {
		getTbMovimientos1().add(tbMovimientos1);
		tbMovimientos1.setTbUsuario1(this);

		return tbMovimientos1;
	}

	public TbMovimiento removeTbMovimientos1(TbMovimiento tbMovimientos1) {
		getTbMovimientos1().remove(tbMovimientos1);
		tbMovimientos1.setTbUsuario1(null);

		return tbMovimientos1;
	}

	public List<TbRolUsuario> getTbRolUsuarios() {
		return this.tbRolUsuarios;
	}

	public void setTbRolUsuarios(List<TbRolUsuario> tbRolUsuarios) {
		this.tbRolUsuarios = tbRolUsuarios;
	}

	public TbRolUsuario addTbRolUsuario(TbRolUsuario tbRolUsuario) {
		getTbRolUsuarios().add(tbRolUsuario);
		tbRolUsuario.setTbUsuario(this);

		return tbRolUsuario;
	}

	public TbRolUsuario removeTbRolUsuario(TbRolUsuario tbRolUsuario) {
		getTbRolUsuarios().remove(tbRolUsuario);
		tbRolUsuario.setTbUsuario(null);

		return tbRolUsuario;
	}

}