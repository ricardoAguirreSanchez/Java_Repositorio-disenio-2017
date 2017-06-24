package com.utn.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.utn.model.Cuenta;
import com.utn.model.Empresa;
import com.utn.model.Indicador;

@Component
public class EmpresaDAO {
	
	private ClassLoader classLoader = getClass().getClassLoader();
	private String fileName = classLoader.getResource("empresas.json").getFile();
	private Type jsonEmpresaType = new TypeToken<List<Empresa>>(){}.getType();

	//El setDateFormat permite parsear a tipo Date, se puede buscar como usar otro tipo de dato también
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

	public List<Empresa> getEmpresas()  {
		List<Empresa> listaEmpresas = new ArrayList<Empresa>();
		try {
			JsonReader reader = new JsonReader(new FileReader(fileName));
			listaEmpresas = gson.fromJson(reader, jsonEmpresaType);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaEmpresas;
	}
	
	//devuelve la empresa mas antigua o null
	public Empresa getEmpresaMasAntigua(){
		List<Empresa> listaEmpresas = this.getEmpresas();
		Empresa empresaGanadora = listaEmpresas.get(0);
		for (Empresa unaEmpresa : listaEmpresas){
			if (unaEmpresa.getFechaCreacion().getYear()<empresaGanadora.getFechaCreacion().getYear()){
				empresaGanadora = unaEmpresa;
			}
		}
		
		
		//Fecha actual desglosada:
        Calendar fecha = Calendar.getInstance();
        int anioActual = fecha.get(Calendar.YEAR);
		
		//Verifico que la mas antigua sea de 10 anos como minimo
		if(empresaGanadora.getFechaCreacion().getYear() + 10 > anioActual){
			empresaGanadora = null;
		}
		return empresaGanadora;
		
	}
}
