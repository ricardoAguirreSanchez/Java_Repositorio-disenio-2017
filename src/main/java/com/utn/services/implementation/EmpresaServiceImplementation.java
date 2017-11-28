package com.utn.services.implementation;

import com.utn.model.Empresa;
import com.utn.repositorio.Empresas;
import com.utn.services.EmpresaService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServiceImplementation implements EmpresaService {
    private final Empresas empresas;

    @Autowired
    public EmpresaServiceImplementation(Empresas empresas) {
        this.empresas = empresas;
    }

    public List<Empresa> getEmpresas(long usuarioId) {
        return Lists.newArrayList(empresas.findByUsuarioId(usuarioId));
    }
    
}
