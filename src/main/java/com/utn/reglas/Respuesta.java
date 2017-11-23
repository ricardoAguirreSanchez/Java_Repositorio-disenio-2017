package com.utn.reglas;

import com.utn.model.Empresa;

import java.util.HashMap;

public class Respuesta {
	private HashMap<String,Empresa> hash = new HashMap<>();
	
	public HashMap<String, Empresa> getHash() {
		return hash;
	}

	public void agregar(String regla, Empresa empresa){
		this.getHash().put(regla, empresa);
	}
	public void setHash(HashMap<String, Empresa> hash) {
		this.hash = hash;
	}

	
}
