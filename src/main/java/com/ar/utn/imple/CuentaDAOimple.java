package com.ar.utn.imple;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import com.ar.utn.dao.CuentaDAO;
import com.ar.utn.dto.CuentaDTO;

@Component
public class CuentaDAOimple implements CuentaDAO {

	
	public ArrayList<CuentaDTO> buscaCuentasPor(String nombreEmpresa, String periodo, int anio) {
		// Aca busca del archivo y arma una lista de cuentas
		return null;
	}


	public ArrayList<CuentaDTO> buscarCuentasTotales() {
		// Aca busca del archivo y arma una lista de cuentas
		return null;
	}

}
