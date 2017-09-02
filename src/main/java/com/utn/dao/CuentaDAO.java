package com.utn.dao;

import com.utn.model.Cuenta;
import com.utn.model.CuentaValores;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.utn.repositorio.Repositorio;
import org.springframework.stereotype.Component;

import javax.persistence.Persistence;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import static org.hibernate.jpa.AvailableSettings.PERSISTENCE_UNIT_NAME;

@Component
public class CuentaDAO {
	private static final String PERSISTENCE_UNIT_NAME = "DDS";
	private ClassLoader classLoader = getClass().getClassLoader();
	private String fileName = classLoader.getResource("cuentas.json").getFile();
	private Type jsonCuentaType = new TypeToken<List<Cuenta>>(){}.getType();
	//El setDateFormat permite parsear a tipo Date, se puede buscar como usar otro tipo de dato también
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	private Repositorio repositorio = new Repositorio(Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager());

	public List<Cuenta> getCuentas()  {
		List<Cuenta> listaCuentas = new ArrayList<>();
		listaCuentas.addAll(getCuentasArchivo());
		listaCuentas.addAll(getCuentasDB());
		return listaCuentas;
	}

	public Double totalROEUltimosNAnios(Cuenta cuenta,int ultimosAnios){
		if (cuenta==null){
			return (double) 0;
		}
		else{
			Double total = (double) 0;
			//Fecha actual desglosada:
			Calendar fecha = Calendar.getInstance();
			int anioActual = fecha.get(Calendar.YEAR);

			for(CuentaValores unaCuentaValor : cuenta.getCuentaValores()){
				if(unaCuentaValor.getFechaFin().getYear() + ultimosAnios <= anioActual){
					total = total + unaCuentaValor.getRoi();
				}
			}

			return total;
		}


	}

	public Double totalCostltimosNAnios(Cuenta cuenta, int ultimosAnios) {
		if (cuenta==null){
			return (double) 0;
		}
		else{
			Double total = (double) 0;
			//Fecha actual desglosada:
			Calendar fecha = Calendar.getInstance();
			int anioActual = fecha.get(Calendar.YEAR);

			for(CuentaValores unaCuentaValor : cuenta.getCuentaValores()){
				if(unaCuentaValor.getFechaFin().getYear() + ultimosAnios <= anioActual){
					total = total + unaCuentaValor.getCost();
				}
			}
			return total;
		}

	}
	private List<Cuenta> getCuentasDB() {
		return repositorio.cuentas().getCuentas();
	}

	private List<Cuenta> getCuentasArchivo() {
		List<Cuenta> cuentas = new ArrayList<>();
		try {
			JsonReader reader = new JsonReader(new FileReader(fileName));
			cuentas = gson.fromJson(reader, jsonCuentaType);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return cuentas;
	}
}


