package com.utn.indicadores;

import com.utn.dao.CuentaValoresDAO;
import com.utn.dao.IndicadorDAO;
import com.utn.services.implementation.IndicadorServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by nicolaslamas on 18/11/17.
 */
@Component
public class EvaluacionIndicadoresScheduled {

    @Autowired
    private IndicadorDAO indicadorDAO;
    @Autowired
    private CuentaValoresDAO cuentaValoresDAO;

    @PostConstruct
    public void evaluarIndicadores(){

    }
}
