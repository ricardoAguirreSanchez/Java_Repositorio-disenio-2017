package com.utn.services.implementation;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.utn.dao.IndicadorDAO;
import com.utn.dao.MetodologiaDAO;
import com.utn.model.Cuenta;
import com.utn.model.Metodologia;
import com.utn.services.MetodologiaService;

public class MetodologiaServiceImplementation implements MetodologiaService{
	
	
	private MetodologiaDAO metodologiaDAO;
	
    @Autowired
    public MetodologiaServiceImplementation(MetodologiaDAO metodologiaDAO) {
        this.metodologiaDAO = metodologiaDAO;
    }
    
	
	public HashMap<String, Cuenta> realizaComparacion(Metodologia metodologia) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Metodologia> getMetodologias() {
		return metodologiaDAO.getMetodologias();
	}

}
