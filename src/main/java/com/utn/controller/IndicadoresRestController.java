package com.utn.controller;

import com.utn.indicadores.IndicadorCompiler;
import com.utn.model.Indicador;
import com.utn.services.IndicadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class IndicadoresRestController {

    @Autowired
    private IndicadorService indicadorService;
    private IndicadorCompiler indicadorCompiler =  new IndicadorCompiler();

    @RequestMapping(value= "/indicadores", method= RequestMethod.GET)
    public List<Indicador> getIndicadores(){
        return indicadorService.getIndicadores();
    }

    @RequestMapping(value= "/indicadores", method= RequestMethod.POST)
    public boolean postIndicadores(@RequestParam String nombre, @RequestParam String indicador){
        if(indicadorCompiler.isIndicadorValido(indicador)){
            indicadorService.setIndicador(nombre, indicador);
            return true;
        }
        return false;
    }

}
