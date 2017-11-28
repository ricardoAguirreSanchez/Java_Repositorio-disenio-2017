package com.utn.services;

import com.utn.model.Indicador;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nicolas on 29/05/17.
 */
@Service
public interface IndicadorService {

    List<Indicador> getIndicadores(long usuarioId);

    void setIndicador(String nombre, String indicador);

    Double evaluarIndicador(long indicadorId, long cuentaId, long cuentaValorId);

    void preLoadIndicador(String userId, String nombre, String indicador);
}

