package com.utn.reglas;

import java.util.HashMap;

import com.utn.model.Cuenta;

public class Respuesta {
	private String valor;
	private HashMap<String,String> hash = new HashMap<String,String>();
	
	public HashMap<String, String> getHash() {
		return hash;
	}

	public void agregar(String valor){
		this.getHash().put("nombre", valor);
	}
	public void setHash(HashMap<String, String> hash) {
		this.hash = hash;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
}
