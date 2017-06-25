package com.utn.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.utn.model.Cuenta;
import com.utn.model.Empresa;
import com.utn.model.Indicador;
import com.utn.model.Metodologia;
import com.utn.services.implementation.CuentaServiceImplementation;

@Component
public class MetodologiaDAO {
	private ClassLoader classLoader = getClass().getClassLoader();
	private String fileName = classLoader.getResource("metodologias.json").getFile();
	private Type jsonMetodologiaType = new TypeToken<List<Metodologia>>(){}.getType();
	
	
	//El setDateFormat permite parsear a tipo Date, se puede buscar como usar otro tipo de dato también
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	List<Metodologia> listaMetodologia = generaMetodologias();
	
	public List<Metodologia> generaMetodologias()  {
		List<Metodologia> metodologias = new ArrayList<Metodologia>();
		try {
			JsonReader reader = new JsonReader(new FileReader(fileName));
			metodologias = gson.fromJson(reader, jsonMetodologiaType);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return metodologias;
	}
	
	public List<Metodologia> getMetodologias()  {
        return listaMetodologia;
      }
	
	
	public void setMetodologia(Metodologia metodologia) {
		// TODO Auto-generated method stub
		listaMetodologia.add(metodologia);
		
	}
	
}
