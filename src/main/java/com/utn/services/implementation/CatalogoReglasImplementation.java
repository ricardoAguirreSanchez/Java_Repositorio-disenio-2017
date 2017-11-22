package com.utn.services.implementation;

import com.utn.model.Regla;
import com.utn.repositorio.Reglas;
import com.utn.services.CatalogoReglasService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CatalogoReglasImplementation implements CatalogoReglasService{

    private final Reglas reglas;

    @Autowired
    public CatalogoReglasImplementation(Reglas reglas) {
        this.reglas = reglas;
    }

	@Override
	public List<Regla> getReglas() {
		 return Lists.newArrayList(reglas.findAll());
	}

}
