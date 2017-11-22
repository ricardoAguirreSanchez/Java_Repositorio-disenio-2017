package com.utn.services;

import com.utn.model.Empresa;
import com.utn.model.Metodologia;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface MetodologiaService {
	
	//Devuelve todas las metodologias
	public List<Metodologia> getMetodologias();
	
	//Guarda una metodologia
	public void setMetodologia(Metodologia metodologia);
	
	//Recibe un objeto Metodologia (cargado con las condiciones respectivas), compara cada condicion
	//con las cuentas y devuelve un HasMap de la condicion (clave) y empresa (ganadora para esa condicion)
	public HashMap<String,Empresa> realizaComparacion(Metodologia metodologia);
	
}
