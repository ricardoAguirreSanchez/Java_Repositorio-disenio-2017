package com.utn.services;

import java.util.HashMap;
import java.util.List;

import com.utn.model.Empresa;
import com.utn.model.Metodologia;

public interface MetodologiaService {
	
	//Devuelve todas las metodologias
	public List<Metodologia> getMetodologias();
	
	//Recibe un objeto Metodologia (cargado con las condiciones respectivas), compara cada condicion
	//con las cuentas y devuelve un HasMap de la condicion (clave) y empresa (ganadora para esa condicion)
	public HashMap<String,Empresa> realizaComparacion(Metodologia metodologia);
	
}
