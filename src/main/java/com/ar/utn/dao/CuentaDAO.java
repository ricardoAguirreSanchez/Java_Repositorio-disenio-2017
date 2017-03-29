package com.ar.utn.dao;

import java.util.ArrayList;

import com.ar.utn.dto.CuentaDTO;

public interface CuentaDAO {
	public ArrayList<CuentaDTO> buscaCuentasPor(String nombreEmpresa,String periodo,int anio);
	public ArrayList<CuentaDTO> buscarCuentasTotales();
}
