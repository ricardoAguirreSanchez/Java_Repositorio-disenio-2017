package com.ar.utn.imple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ar.utn.dao.CuentaDAO;
import com.ar.utn.dto.CuentaDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Component
public class CuentaDAOimple implements CuentaDAO {

	
	public ArrayList<CuentaDTO> buscaCuentasPor(String nombreEmpresa, String periodo, int anio) {
		// Aca busca del archivo y arma una lista de cuentas
		return null;
	}


	public ArrayList<CuentaDTO> buscarCuentasTotales()  {
		try {
			//Leo el fichero de json
			String cadena;
			String result = new String();
	        FileReader f = new FileReader("C:/Users/ricardo/Desktop/eclipse-mars/eclipse/workspace-tp/tp-disenio-ejercicio/Fichero123.txt");
	        BufferedReader b = new BufferedReader(f);
	        while((cadena = b.readLine())!=null) {
	            result= result + cadena;
	        }
	        b.close();		
			
	        //Deserializando
	        Gson gson = new Gson();
			Type lista= new TypeToken<List<CuentaDTO>>(){}.getType();
			ArrayList<CuentaDTO> listaCuentas = gson.fromJson(result, lista);
			return listaCuentas;
		} catch (Exception e) {
			System.out.println("ERROR AL BUSCAR CUENTAS TOTALES");
			return null;
		}
		
	}

}
