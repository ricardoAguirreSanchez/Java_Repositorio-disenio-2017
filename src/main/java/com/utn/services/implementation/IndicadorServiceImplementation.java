package com.utn.services.implementation;

import com.utn.dao.IndicadorDAO;
import com.utn.model.Indicador;
import com.utn.services.IndicadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nicolas on 29/05/17.
 */
@Service
public class IndicadorServiceImplementation implements IndicadorService{

    private final IndicadorDAO indicadorDAO;

    @Autowired
    public IndicadorServiceImplementation(IndicadorDAO indicadorDAO) {
        this.indicadorDAO = indicadorDAO;
    }

    @Override
    public List<Indicador> getIndicadores() {
        return indicadorDAO.getIndicadores();
    }

    @Override
    public void setIndicador(String nombre, String indicador) {
        indicadorDAO.agregarIndicador(nombre,indicador);
    }
}
