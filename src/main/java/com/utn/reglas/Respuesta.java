package com.utn.reglas;

import java.util.HashMap;

import com.utn.model.Cuenta;
import com.utn.model.Empresa;

//Es necesario crear y usar esta clase en vez de mandar directamente el HashMap al drl pork no lo reconoce
public class Respuesta {
	private HashMap<String,Empresa> hash = new HashMap<String,Empresa>();
	
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
