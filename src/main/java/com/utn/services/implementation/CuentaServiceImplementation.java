package com.utn.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.model.Cuenta;
import com.utn.model.Empresa;
import com.utn.repositorio.Cuentas;
import com.utn.services.CuentaService;


@Service
public class CuentaServiceImplementation implements CuentaService{

    @Autowired
    private final Cuentas cuentas;

    public CuentaServiceImplementation(Cuentas cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public List<Cuenta> getCuentas(List<Empresa> list) {
    	List<Cuenta> cuentasList = new ArrayList<Cuenta>();
    	for(Empresa empresa: list){
    		cuentasList.addAll(cuentas.findByEmpresaId(empresa.getId()));
    	}
    	return cuentasList;
    }
    
    @Override
    public List<Cuenta> getCuentas() {
        return Lists.newArrayList(cuentas.findAll());
    }
}
