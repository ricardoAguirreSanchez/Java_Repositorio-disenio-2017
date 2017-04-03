package com.ar.utn.services.mock;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ar.utn.dto.CuentaDTO;


public interface ServicioMock {
	
	public ArrayList<CuentaDTO> consultaCuentasPor(String nombreEmpresa, String periodo, int anio);
	public ArrayList<CuentaDTO> consultaCuentasTotales();
}
