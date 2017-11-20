package com.utn.dao;

import com.google.common.collect.Lists;
import com.utn.model.IndicadorAplicado;
import com.utn.repositorio.IndicadoresAplicados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by nicolaslamas on 18/11/17.
 */
@Component
public class IndicadorAplicadoDAO {

    @Autowired
    private IndicadoresAplicados indicadoresAplicados;

    public List<IndicadorAplicado> getIndicadoresAplicados()  {
        return Lists.newArrayList(indicadoresAplicados.findAll());
    }

    public void dropRows() {
        indicadoresAplicados.deleteAll();
    }

    public void persist(IndicadorAplicado ia) {
        indicadoresAplicados.save(ia);
    }

    public IndicadorAplicado getByCuentaIdIndicadorIdCuentaValorId(long cuentaId, long indicadorId, long cuentaValorId) {
        return indicadoresAplicados.findByCuentaIdAndIndicadorIdAndCuentaValorId(cuentaId, indicadorId, cuentaValorId);
    }

}
