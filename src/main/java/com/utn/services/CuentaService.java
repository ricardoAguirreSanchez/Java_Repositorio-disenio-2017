package com.utn.services;

import com.utn.model.Cuenta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CuentaService {

    List<Cuenta> getCuentas();

}
