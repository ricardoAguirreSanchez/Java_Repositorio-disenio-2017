package com.utn.services;

import com.utn.model.Cuenta;
import com.utn.model.Empresa;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface CuentaService {
    List<Cuenta> getCuentas(List<Empresa> list);

	List<Cuenta> getCuentas();
}
