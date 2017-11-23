package com.utn.services.implementation;

import com.utn.model.Cuenta;
import com.utn.repositorio.Cuentas;
import com.utn.services.CuentaService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CuentaServiceImplementation implements CuentaService{

    @Autowired
    private final Cuentas cuentas;

    public CuentaServiceImplementation(Cuentas cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public List<Cuenta> getCuentas() {
        return Lists.newArrayList(cuentas.findAll());
    }
}
