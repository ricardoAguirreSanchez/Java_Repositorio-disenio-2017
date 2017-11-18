package com.utn.dao;

import com.utn.model.CuentaValores;
import com.utn.repositorio.CuentasValores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by nicolaslamas on 18/11/17.
 */
@Component
public class CuentaValoresDAO {

    @Autowired
    private CuentasValores cuentasValores;

    public List<CuentaValores> getValoresByCuentaId(long cuentaId) {
        return cuentasValores.findCuentaValoresByCuentaId(cuentaId);
    }
    public void persist(CuentaValores cv) {
        cuentasValores.save(cv);
    }

    public CuentaValores findById(Long id) {
        return cuentasValores.findOne(id);
    }
}
