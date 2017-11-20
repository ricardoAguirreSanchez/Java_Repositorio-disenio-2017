package com.utn.indicadores;

import com.utn.batch.BatchCuentasConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by nicolaslamas on 18/11/17.
 */
@Component
public class EvaluacionIndicadoresScheduled {

    private final EvaluacionIndicadores evaluador;
    private static final Logger log = LoggerFactory.getLogger(EvaluacionIndicadoresScheduled.class);

    @Autowired
    public EvaluacionIndicadoresScheduled(EvaluacionIndicadores evaluador) {
        this.evaluador = evaluador;
    }

    @PostConstruct
    public void evaluarIndicadores(){
        log.info("Starting to pre load indicators");
        evaluador.dropAllIndicadoresAplicados();
        evaluador.evaluateAll();
        log.info("Finished pre loading indicators");
    }


}
