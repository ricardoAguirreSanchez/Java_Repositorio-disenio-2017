package com.ar.utn.dto;

import org.springframework.stereotype.Component;

@Component
public class CuentaDTO {
	int id;
	
//	  Periodo de semestre, puede ser:
//	  1: primer semestre
//	  2: segundo semestre
//	  3: todo el año
	int periodo;
	
	String nombreCuenta;
	
	String nombreEmpresa;
	
	int monto;
	
	int anio;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	public String getNombreCuenta() {
		return nombreCuenta;
	}
	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	
}
