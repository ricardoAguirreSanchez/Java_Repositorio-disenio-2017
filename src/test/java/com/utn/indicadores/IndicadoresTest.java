package com.utn.indicadores;

import com.utn.model.CuentaValores;
import com.utn.model.Indicador;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nicolaslamas on 28/11/17.
 */
public class IndicadoresTest {

    @Test
    public void indicadorValido(){
        IndicadorCompiler compiler =  new IndicadorCompiler();
        Indicador indicador1 = new Indicador();
        Indicador indicador2 = new Indicador();

        indicador1.setExpresion("GROSS_BOOKING - COST + COST");
        indicador2.setExpresion("INVALID EXPRESSION");

        Assert.assertTrue(compiler.isIndicadorValido(indicador1.getExpresion()));
        Assert.assertFalse(compiler.isIndicadorValido(indicador2.getExpresion()));
    }

    @Test
    public void evaluarIndiador() {
        IndicadorCompiler compiler =  new IndicadorCompiler();

        Indicador indicador = new Indicador();
        indicador.setExpresion("GROSS_BOOKING - COST + COST");

        CuentaValores cuentaValores = new CuentaValores();
        cuentaValores.setGrossBooking(20.0);
        cuentaValores.setCost(10.0);
        Assert.assertEquals(Double.valueOf(20.0), compiler.evaluarIndicador(indicador.getExpresion(), cuentaValores));
    }
}
