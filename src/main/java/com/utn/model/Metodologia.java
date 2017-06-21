package com.utn.model;

import java.util.ArrayList;

public class Metodologia {
	private String nombre;
	private ArrayList<String> listaCondiciones;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<String> getListaCondiciones() {
		return listaCondiciones;
	}
	public void setListaCondiciones(ArrayList<String> listaCondiciones) {
		this.listaCondiciones = listaCondiciones;
	}

}
