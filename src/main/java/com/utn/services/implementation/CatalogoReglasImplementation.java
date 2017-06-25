package com.utn.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.utn.dao.CatalogoReglasDAO;
import com.utn.dao.CuentaDAO;
import com.utn.model.Cuenta;
import com.utn.services.CatalogoReglasService;

public class CatalogoReglasImplementation implements CatalogoReglasService{

    private final CatalogoReglasDAO catalogoReglas;

    @Autowired
    public CatalogoReglasImplementation(CatalogoReglasDAO catalogoReglas) {
        this.catalogoReglas = catalogoReglas;
    }


	@Override
	public List<String> getReglas() {
		return catalogoReglas.getReglas();
	}

}
