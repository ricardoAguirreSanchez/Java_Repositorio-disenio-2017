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

public class CatalogoReglasDAO {
	private ClassLoader classLoader = getClass().getClassLoader();
	private String fileName = classLoader.getResource("reglas.json").getFile();
	private Type jsonReglasType = new TypeToken<List<Cuenta>>(){}.getType();

	//El setDateFormat permite parsear a tipo Date, se puede buscar como usar otro tipo de dato también
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

	public List<String> getReglas()  {
		List<String> listaReglas = new ArrayList<String>();
		try {
			JsonReader reader = new JsonReader(new FileReader(fileName));
			listaReglas = gson.fromJson(reader, jsonReglasType);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaReglas;
	}

}
