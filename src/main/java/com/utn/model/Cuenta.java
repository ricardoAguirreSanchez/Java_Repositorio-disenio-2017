package com.utn.model;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.StringJoiner;

@Component
public class Cuenta {

	private long id;
	private String tipoCuenta;
	private String empresa;
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

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public List<CuentaValores> getCuentaValores() {return cuentaValores;}

	public void setCuentaValores(List<CuentaValores> cuentaValores) {this.cuentaValores = cuentaValores;}

	@Override
	public String toString() {

		return new StringJoiner(", ", Cuenta.class.getSimpleName() + "{", "}")
				.add("tipoCuenta= " + tipoCuenta)
				.add("empresa= " + empresa)
				.add("cuentaValores= " + cuentaValores)
				.toString();
	}

}
