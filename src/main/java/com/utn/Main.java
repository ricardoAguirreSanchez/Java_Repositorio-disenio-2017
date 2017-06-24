package com.utn;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.*;
import org.drools.core.*;
import org.drools.core.WorkingMemory;

import com.utn.dao.MetodologiaDAO;
import com.utn.model.Cuenta;
import com.utn.model.Metodologia;
import com.utn.reglas.Respuesta;
import com.utn.reglas.Sesion;
import com.utn.services.implementation.MetodologiaServiceImplementation;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sesion rc = new Sesion();
		Metodologia product = new Metodologia();
		product.setNombre("Ricardo");
		WorkingMemory workingMemory;
		Respuesta product1 = new Respuesta();
		HashMap<String,String> li = new HashMap<String,String>(); 
		product1.setHash(li);
		
		try {
			workingMemory = rc.iniciar();
			workingMemory.insert(product);
			workingMemory.insert(product1);
			workingMemory.fireAllRules();
			workingMemory.dispose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("El nombre del producto es: "+product.getNombre()+ product1.getHash().get("nombre"));

		
	}

}
