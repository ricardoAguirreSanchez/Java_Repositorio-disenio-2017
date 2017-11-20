package com.utn.services.implementation;

import com.utn.dao.IndicadorAplicadoDAO;
import com.utn.dao.IndicadorDAO;
import com.utn.indicadores.EvaluacionIndicadores;
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
    private final IndicadorAplicadoDAO indicadorAplicadoDAO;
    private final EvaluacionIndicadores evaluacionIndicadores;

    @Autowired
    public IndicadorServiceImplementation(IndicadorDAO indicadorDAO, IndicadorAplicadoDAO indicadorAplicadoDAO,
                                          EvaluacionIndicadores evaluacionIndicadores) {
        this.indicadorDAO = indicadorDAO;
        this.indicadorAplicadoDAO = indicadorAplicadoDAO;
        this.evaluacionIndicadores = evaluacionIndicadores;
    }

    @Override
    public List<Indicador> getIndicadores() {
        return indicadorDAO.getIndicadores();
    }

    @Override
    public void setIndicador(String nombre, String indicador) {
        indicadorDAO.addIndicador(nombre,indicador);
    }

    @Override
    public Double evaluarIndicador(long indicadorId, long cuentaId, long cuentaValorId) {
        return indicadorAplicadoDAO.getByCuentaIdIndicadorIdCuentaValorId(cuentaId, indicadorId, cuentaValorId).getValor();
    }

    @Override
    public void preLoadIndicador(String userId, String nombre, String indicador) {
        evaluacionIndicadores.evaluateSingle(userId, nombre, indicador);
    }

}
