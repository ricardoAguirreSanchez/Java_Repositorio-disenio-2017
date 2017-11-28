package com.utn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utn.indicadores.IndicadorCompiler;
import com.utn.model.CuentaValoresView;
import com.utn.model.Indicador;
import com.utn.services.IndicadorService;



@RestController
public class IndicadoresRestController {

    private final IndicadorService indicadorService;
    private IndicadorCompiler indicadorCompiler =  new IndicadorCompiler();

    @Autowired
    public IndicadoresRestController(IndicadorService indicadorService) {
        this.indicadorService = indicadorService;
    }

    @RequestMapping(value= "/indicadores", method= RequestMethod.GET)
    public List<Indicador> getIndicadores(HttpServletRequest request){
    	HttpSession session=request.getSession();
        return indicadorService.getIndicadores((long)session.getAttribute("usuarioId"));
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

    @RequestMapping(value= "/aplicarIndicadores", method= RequestMethod.POST)
            public Double getEvaluacionIndicador(@RequestBody CuentaValoresView valores){
        return  indicadorService.evaluarIndicador(valores.getIndicadorId(), valores.getCuentaId(), valores.getValorCuentaId());
    }


}
