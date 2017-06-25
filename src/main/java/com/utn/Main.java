package com.utn;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.*;
import org.drools.core.*;
import org.drools.core.WorkingMemory;

import com.utn.dao.MetodologiaDAO;
import com.utn.model.Cuenta;
import com.utn.model.Empresa;
import com.utn.model.Metodologia;
import com.utn.reglas.Respuesta;
import com.utn.reglas.Sesion;
import com.utn.services.implementation.MetodologiaServiceImplementation;

public class Main {

	public static void main(String[] args) {
		
		//TEST DE LONGEVIDAD
		MetodologiaDAO metodologiaDAO = new MetodologiaDAO();
		MetodologiaServiceImplementation msi = new MetodologiaServiceImplementation(metodologiaDAO);
		
		ArrayList<String> listaCondiciones = new ArrayList<>();
		listaCondiciones.add("Longevidad");
		
		Metodologia metodologia = new Metodologia();
		metodologia.setListaCondiciones(listaCondiciones);
		
		HashMap<String,Empresa> hash = msi.realizaComparacion(metodologia);
		System.out.println("La empresa ganadora de Longevidad es: "+ hash.get("Longevidad").getNombre() );
		//----------------------------------
		
		//TEST DE Maximizar ROE
		MetodologiaDAO metodologiaDAO1 = new MetodologiaDAO();
		MetodologiaServiceImplementation msi1 = new MetodologiaServiceImplementation(metodologiaDAO1);
		
		ArrayList<String> listaCondiciones1 = new ArrayList<>();
		listaCondiciones1.add("Maximizar ROE");
		
		Metodologia metodologia1 = new Metodologia();
		metodologia1.setListaCondiciones(listaCondiciones1);
		
		HashMap<String,Empresa> hash1 = msi1.realizaComparacion(metodologia1);
		System.out.println("La empresa ganadora de Maximizar ROE es: "+ hash1.get("Maximizar ROE").getNombre() );
		//----------------------------------
		
		//TEST DE Margenes de ganancia
		MetodologiaDAO metodologiaDAO2 = new MetodologiaDAO();
		MetodologiaServiceImplementation msi2 = new MetodologiaServiceImplementation(metodologiaDAO2);
		
		ArrayList<String> listaCondiciones2 = new ArrayList<>();
		listaCondiciones2.add("Margenes de ganancia");
		
		Metodologia metodologia2 = new Metodologia();
		metodologia2.setListaCondiciones(listaCondiciones2);
		
		HashMap<String,Empresa> hash2 = msi2.realizaComparacion(metodologia2);
		System.out.println("La empresa ganadora de Margenes de ganancia es: "+ hash2.get("Margenes de ganancia").getNombre() );
		//----------------------------------
		
		
		//TEST DE "Minimizar deuda"
		MetodologiaDAO metodologiaDAO3 = new MetodologiaDAO();
		MetodologiaServiceImplementation msi3 = new MetodologiaServiceImplementation(metodologiaDAO3);
		
		ArrayList<String> listaCondiciones3 = new ArrayList<>();
		listaCondiciones3.add("Minimizar deuda");
		
		Metodologia metodologia3 = new Metodologia();
		metodologia3.setListaCondiciones(listaCondiciones3);
		
		HashMap<String,Empresa> hash3 = msi3.realizaComparacion(metodologia3);
		System.out.println("La empresa ganadora de Minimizar deuda es: "+ hash3.get("Minimizar deuda").getNombre() );
		//----------------------------------
		
		
	}

}
