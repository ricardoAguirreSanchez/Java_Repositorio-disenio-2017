package com.utn.services.implementation;

import com.utn.dao.CatalogoReglasDAO;
import com.utn.services.CatalogoReglasService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
