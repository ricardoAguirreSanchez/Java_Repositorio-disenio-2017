package com.utn.controller;

import com.utn.model.Cuenta;
import com.utn.model.Metodologia;
import com.utn.services.CuentaService;
import com.utn.services.MetodologiaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MetodologiaRestController {

    @Autowired
    private MetodologiaService metodologiaService;

    @RequestMapping(value= "/metodologias", method= RequestMethod.GET)
    public List<Metodologia> getCuentas(){
        return  metodologiaService.getMetodologias();
    }

//    @RequestMapping(value= "/cuentas/{id}", method= RequestMethod.GET)
//    public Cuenta getCuentaById(@PathVariable(value="id") final long id){
//        return  cuentaService.getCuentas().stream().filter(cuenta -> id == cuenta.getId()).findFirst().get();
//    }
    
    @RequestMapping(value= "/agregarMetodologia", method= RequestMethod.POST)
    public Boolean addMetodologia(@RequestParam String metodologia, @RequestParam ArrayList<String> reglasSeleccionadas){
        String nombre=metodologia;
    	return  true;
    }
    
}
