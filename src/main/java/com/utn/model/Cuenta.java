package com.utn.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
import java.util.StringJoiner;

@Component
@Entity
@Table(name = "CUENTA")
public class Cuenta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "tipo_cuenta")
	private String tipoCuenta;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "empresa_id", referencedColumnName = "id")
	private Empresa empresa;
	@OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
	private List<CuentaValores> cuentaValores;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<CuentaValores> getCuentaValores() {return null;}

	@Override
	public String toString() {

		return new StringJoiner(", ", Cuenta.class.getSimpleName() + "{", "}")
				.add("tipoCuenta= " + tipoCuenta)
				.add("empresa= " + empresa)
				.add("cuentaValores= " + null)
				.toString();
	}

}
