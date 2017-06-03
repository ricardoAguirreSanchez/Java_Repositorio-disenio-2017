package com.utn.dao;

import com.utn.model.Cuenta;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class CuentaDAO {

	private ClassLoader classLoader = getClass().getClassLoader();
	private String fileName = classLoader.getResource("cuentas.json").getFile();
	private Type jsonCuentaType = new TypeToken<List<Cuenta>>(){}.getType();

	//El setDateFormat permite parsear a tipo Date, se puede buscar como usar otro tipo de dato también
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

	public List<Cuenta> getCuentas()  {
		List<Cuenta> listaCuentas = new ArrayList<Cuenta>();
		try {
			JsonReader reader = new JsonReader(new FileReader(fileName));
			listaCuentas = gson.fromJson(reader, jsonCuentaType);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaCuentas;
	}

}


