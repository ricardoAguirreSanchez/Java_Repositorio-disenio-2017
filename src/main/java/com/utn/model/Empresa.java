package com.utn.model;

import java.sql.Date;
import java.util.ArrayList;

public class Empresa {
	private ArrayList<Long> listaIdCuentas;
	private Date fechaCreacion;
	private String nombre;
	
	//Se agregan estos dos para calcular su nivel de deuda
	private Double totalPasivo;
	private Double capitalContable;
	
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
	
	
	
	public ArrayList<Long> getListaIdCuentas() {
		return listaIdCuentas;
	}
	public void setListaIdCuentas(ArrayList<Long> listaNombreCuentas) {
		this.listaIdCuentas = listaNombreCuentas;
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

	
}
