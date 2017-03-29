package com.ar.utn.imple;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ar.utn.dao.CuentaDAO;
import com.ar.utn.dto.CuentaDTO;
import com.ar.utn.services.Servicio;

@Service
public class ServicioImple implements Servicio {

	@Autowired
	CuentaDAO cuenta;

	public ArrayList<CuentaDTO> consultaCuentasPor(String nombreEmpresa, String periodo, int anio) {

		return cuenta.buscaCuentasPor(nombreEmpresa, periodo, anio);
	}

	public ArrayList<CuentaDTO> consultaCuentasTotales() {

		return cuenta.buscarCuentasTotales();
	}

}
