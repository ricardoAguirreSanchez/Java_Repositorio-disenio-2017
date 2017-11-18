package com.utn.services.implementation;

import com.utn.dao.CuentaDAO;
import com.utn.model.Cuenta;
import com.utn.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CuentaServiceImplementation implements CuentaService{

    @Autowired
    private final CuentaDAO cuenta;

    public CuentaServiceImplementation(CuentaDAO cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public List<Cuenta> getCuentas() {
        return cuenta.getCuentas();

    }
}
