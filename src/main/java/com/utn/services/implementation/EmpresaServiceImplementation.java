package com.utn.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.dao.CuentaDAO;
import com.utn.dao.EmpresaDAO;
import com.utn.model.Cuenta;
import com.utn.model.Empresa;
import com.utn.services.EmpresaService;

@Service
public class EmpresaServiceImplementation implements EmpresaService {
    private final EmpresaDAO empresa;

    @Autowired
    public EmpresaServiceImplementation(EmpresaDAO empresa) {
        this.empresa = empresa;
    }

    public List<Empresa> getEmpresas() {
        return empresa.getEmpresas();

    }
    
}
