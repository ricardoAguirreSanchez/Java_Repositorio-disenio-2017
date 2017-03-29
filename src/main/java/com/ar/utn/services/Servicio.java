package com.ar.utn.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ar.utn.dto.CuentaDTO;


public interface Servicio {
	
	public ArrayList<CuentaDTO> consultaCuentasPor(String nombreEmpresa, String periodo, int anio);
	public ArrayList<CuentaDTO> consultaCuentasTotales();
}
