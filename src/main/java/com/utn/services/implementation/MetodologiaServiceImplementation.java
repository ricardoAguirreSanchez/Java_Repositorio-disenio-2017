package com.utn.services.implementation;

import com.utn.model.Empresa;
import com.utn.model.Metodologia;
import com.utn.reglas.Respuesta;
import com.utn.reglas.Sesion;
import com.utn.repositorio.Metodologias;
import com.utn.services.MetodologiaService;
import org.assertj.core.util.Lists;
import org.drools.core.WorkingMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MetodologiaServiceImplementation implements MetodologiaService{
	
	
	private Metodologias metodologias;
	
    @Autowired
    public MetodologiaServiceImplementation(Metodologias metodologias) {
		this.metodologias = metodologias;
    }
    
	
	public HashMap<String, Empresa> realizaComparacion(Metodologia metodologia) {
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
		return respuesa.getHash();
	}

	
	public List<Metodologia> getMetodologias() {
		return Lists.newArrayList(metodologias.findAll());
	}
	
	public void setMetodologia(Metodologia metodologia){
		metodologias.save(metodologia);
	}

}
