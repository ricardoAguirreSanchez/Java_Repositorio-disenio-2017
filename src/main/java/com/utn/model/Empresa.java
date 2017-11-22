package com.utn.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Entity
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	private String nombre;
	@Column(name = "total_pasivo")
	private Double totalPasivo;
	@Column(name = "capital_contable")
	private Double capitalContable;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.MERGE)
	private List<Cuenta> cuentas;


	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Double getTotalPasivo() {
		return totalPasivo;
	}
	public void setTotalPasivo(Double totalPasivo) {
		this.totalPasivo = totalPasivo;
	}
	public Double getCapitalContable() {
		return capitalContable;
	}
	public void setCapitalContable(Double capitalContable) {
		this.capitalContable = capitalContable;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public Double getMargenTotal() {
		return this.cuentas.stream().mapToDouble(c -> c.totalCostLastYears(10)).sum();
	}

	public Double getRoiTotal() {
		return this.cuentas.stream().mapToDouble(c -> c.totalRoiLastYears(10)).sum();
	}

	public Double getDeuda() {
		return this.totalPasivo / this.capitalContable;
	}
}
