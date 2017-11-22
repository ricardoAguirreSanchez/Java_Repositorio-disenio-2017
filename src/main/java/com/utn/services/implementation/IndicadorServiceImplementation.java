package com.utn.services.implementation;

import com.utn.indicadores.EvaluacionIndicadores;
import com.utn.model.Indicador;
import com.utn.repositorio.Indicadores;
import com.utn.repositorio.IndicadoresAplicados;
import com.utn.services.IndicadorService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nicolas on 29/05/17.
 */
@Service
public class IndicadorServiceImplementation implements IndicadorService{

    private final Indicadores indicadores;
    private final IndicadoresAplicados indicadoresAplicados;
    private final EvaluacionIndicadores evaluacionIndicadores;

    @Autowired
    public IndicadorServiceImplementation(Indicadores indicadores, IndicadoresAplicados indicadoresAplicados,
                                          EvaluacionIndicadores evaluacionIndicadores) {
        this.indicadores = indicadores;
        this.indicadoresAplicados = indicadoresAplicados;
        this.evaluacionIndicadores = evaluacionIndicadores;
    }

    @Override
    public List<Indicador> getIndicadores() {
        return Lists.newArrayList(indicadores.findAll());
    }

    @Override
    public void setIndicador(String nombre, String indicador) {
        Indicador i = new Indicador();
        i.setNombre(nombre);
        i.setExpresion(indicador);
        indicadores.save(i);
    }

    @Override
    public Double evaluarIndicador(long indicadorId, long cuentaId, long cuentaValorId) {
        return indicadoresAplicados.findByCuentaIdAndIndicadorIdAndCuentaValorId(cuentaId, indicadorId, cuentaValorId).getValor();
    }

    @Override
    public void preLoadIndicador(String userId, String nombre, String indicador) {
        evaluacionIndicadores.evaluateSingle(userId, nombre, indicador);
    }

}
