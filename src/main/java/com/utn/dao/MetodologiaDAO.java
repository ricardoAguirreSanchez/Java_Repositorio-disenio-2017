package com.utn.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.utn.model.Cuenta;
import com.utn.model.Metodologia;
import com.utn.services.implementation.CuentaServiceImplementation;

public class MetodologiaDAO {
	private ClassLoader classLoader = getClass().getClassLoader();
	private String fileName = classLoader.getResource("metodologias.json").getFile();
	private Type jsonCuentaType = new TypeToken<List<Cuenta>>(){}.getType();

	//El setDateFormat permite parsear a tipo Date, se puede buscar como usar otro tipo de dato también
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	
	public List<Metodologia> getMetodologias()  {
		List<Metodologia> listaMetodologia = new ArrayList<Metodologia>();
		try {
			JsonReader reader = new JsonReader(new FileReader(fileName));
			listaMetodologia = gson.fromJson(reader, jsonCuentaType);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaMetodologia;
	}
	
	public Cuenta maximoROE(){
		Cuenta cuentaGanadora = new Cuenta();
		CuentaDAO cuentaDAO = new CuentaDAO(); 
		List<Cuenta> listaCuentas = cuentaDAO.getCuentas();
		
		//Comienzo a buscar la mejor cuenta
		for (Cuenta cuenta: listaCuentas){
			if(cuentaDAO.totalROEUltimosNAnios(cuenta,10) > cuentaDAO.totalROEUltimosNAnios(cuentaGanadora,10)){
				cuentaGanadora = cuenta;
			}
		}
		return cuentaGanadora;
	}
}
