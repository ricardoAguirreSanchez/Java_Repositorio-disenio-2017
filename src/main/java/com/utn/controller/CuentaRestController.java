package com.utn.controller;

import com.utn.model.Cuenta;
import com.utn.model.CuentaValores;
import com.utn.model.Empresa;
import com.utn.services.CuentaService;
import com.utn.services.CuentaValoresService;
import com.utn.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class CuentaRestController {

    @Autowired
    private CuentaService cuentaService;
    @Autowired
    private EmpresaService empresaService;
    @Autowired
    private CuentaValoresService cuentaValoresService;

    @RequestMapping(value= "/cuentas", method= RequestMethod.GET)
    public List<Cuenta> getCuentas(HttpServletRequest request){
    	HttpSession session=request.getSession();
        return  cuentaService.getCuentas(empresaService.getEmpresas((long)session.getAttribute("usuarioId")));
    }
    
    @RequestMapping(value= "/empresas", method= RequestMethod.GET)
    public List<Empresa> getEmpresas(HttpServletRequest request){
    	HttpSession session=request.getSession();
        return  empresaService.getEmpresas((long)session.getAttribute("usuarioId"));
    }

    @RequestMapping(value= "/cuentas/{id}", method= RequestMethod.GET)
    public Cuenta getCuentaById(@PathVariable(value="id") final long id){
        return  cuentaService.getCuentas().stream().filter(cuenta -> id == cuenta.getId()).findFirst().get();
    }
    
    @RequestMapping(value= "/agregarCuenta", method= RequestMethod.POST)
    public boolean addCuentas(@RequestParam String nombre, @RequestParam String tipo){
        return  true;
    }

    @RequestMapping(value= "/cuentaValores/{id}", method= RequestMethod.GET)
    public List<CuentaValores> getCuentaValores(@PathVariable(value="id") final long id) {
        return cuentaValoresService.getCuentaValoresByCuentaId(id);
    }
    
}
