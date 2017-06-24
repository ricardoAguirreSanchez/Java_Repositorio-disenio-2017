package com.utn.services.implementation;

import java.util.HashMap;
import java.util.List;

import org.drools.core.WorkingMemory;
import org.springframework.beans.factory.annotation.Autowired;

import com.utn.dao.IndicadorDAO;
import com.utn.dao.MetodologiaDAO;
import com.utn.model.Cuenta;
import com.utn.model.Empresa;
import com.utn.model.Metodologia;
import com.utn.reglas.Respuesta;
import com.utn.reglas.Sesion;
import com.utn.services.MetodologiaService;

public class MetodologiaServiceImplementation implements MetodologiaService{
	
	
	private MetodologiaDAO metodologiaDAO;
	
    @Autowired
    public MetodologiaServiceImplementation(MetodologiaDAO metodologiaDAO) {
        this.metodologiaDAO = metodologiaDAO;
    }
    
	
	public HashMap<String, Empresa> realizaComparacion(Metodologia metodologia) {
		
		HashMap<String,Empresa> resultadoFinal = new HashMap<String,Empresa>();
		Respuesta respuesa = new Respuesta(); 
		Sesion rc = new Sesion();
		WorkingMemory workingMemory;
		try {
			workingMemory = rc.iniciar();
			workingMemory.insert(metodologia);
			workingMemory.insert(respuesa);
			workingMemory.fireAllRules();
			workingMemory.dispose();
		} catch (Exception e) {
			System.out.println("Error al tratar de realizar la comparacion "+e);
		}
		resultadoFinal = respuesa.getHash();
		return resultadoFinal;
	}

	
	public List<Metodologia> getMetodologias() {
		return metodologiaDAO.getMetodologias();
	}

}
