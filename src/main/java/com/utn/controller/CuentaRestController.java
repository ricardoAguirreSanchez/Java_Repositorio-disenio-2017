package com.utn.controller;

import com.utn.model.Cuenta;
import com.utn.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CuentaRestController {

    @Autowired
    private CuentaService cuentaService;

    @RequestMapping(value= "/cuentas", method= RequestMethod.GET)
    public List<Cuenta> getCuentas(){
        return  cuentaService.getCuentas();
    }

    @RequestMapping(value= "/cuentas/{id}", method= RequestMethod.GET)
    public Cuenta getCuentaById(@PathVariable(value="id") final long id){
        return  cuentaService.getCuentas().stream().filter(cuenta -> id == cuenta.getId()).findFirst().get();
    }
}
