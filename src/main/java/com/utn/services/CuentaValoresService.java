package com.utn.services;

import com.utn.model.CuentaValores;

import java.util.List;

/**
 * Created by nicolaslamas on 18/11/17.
 */
public interface CuentaValoresService {

    List<CuentaValores> getCuentaValoresByCuentaId(long cuentaId);

}
