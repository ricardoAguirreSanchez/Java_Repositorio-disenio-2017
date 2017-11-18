package com.utn.services.implementation;

import com.utn.dao.CuentaValoresDAO;
import com.utn.model.CuentaValores;
import com.utn.services.CuentaValoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nicolaslamas on 18/11/17.
 */
@Service
public class CuentaValoresServiceImplementation implements CuentaValoresService {

    @Autowired
    private CuentaValoresDAO cuentaValoresDAO;
    @Override
    public List<CuentaValores> getCuentaValoresByCuentaId(long cuentaId) {
        return cuentaValoresDAO.getValoresByCuentaId(cuentaId);

    }
}
