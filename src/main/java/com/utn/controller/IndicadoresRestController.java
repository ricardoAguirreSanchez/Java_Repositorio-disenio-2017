package com.utn.controller;

import com.utn.indicadores.IndicadorCompiler;
import com.utn.model.Indicador;
import com.utn.services.IndicadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class IndicadoresRestController {

    private final IndicadorService indicadorService;
    private IndicadorCompiler indicadorCompiler =  new IndicadorCompiler();

    @Autowired
    public IndicadoresRestController(IndicadorService indicadorService) {
        this.indicadorService = indicadorService;
    }

    @RequestMapping(value= "/indicadores", method= RequestMethod.GET)
    public List<Indicador> getIndicadores(){
        return indicadorService.getIndicadores();
    }

    @RequestMapping(value= "/indicadores", method= RequestMethod.POST)
    public boolean postIndicadores(@RequestParam String nombre, @RequestParam String indicador, @RequestParam String userId){
        if(indicadorCompiler.isIndicadorValido(indicador)){
            indicadorService.setIndicador(nombre, indicador);
            indicadorService.preLoadIndicador(userId, nombre, indicador);
            return true;
        }
        return false;
    }

    @RequestMapping(value= "/evaluar/indicadores", method= RequestMethod.GET)
            public Double getEvaluacionIndicador(@PathVariable(value="cuentaId") final long cuentaId,
                                         @PathVariable(value="cuentaValorId") final long cuentaValorId,
                                @PathVariable(value="indicadorId") final long indicadorId){
        return  indicadorService.evaluarIndicador(indicadorId, cuentaId, cuentaValorId);
    }


}
