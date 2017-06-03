package com.utn.services;

import java.util.List;

import com.utn.model.Cuenta;
import org.springframework.stereotype.Service;

@Service
public interface CuentaService {

    List<Cuenta> getCuentas();

}
