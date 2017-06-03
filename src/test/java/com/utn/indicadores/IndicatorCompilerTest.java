package com.utn.indicadores;

import com.utn.model.CuentaValores;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nicolas on 19/05/17.
 */
public class IndicatorCompilerTest {

    private IndicadorCompiler compiler;
    private CuentaValores cuenta;
    @Before
    public void before() {
        compiler = new IndicadorCompiler();
        cuenta = new CuentaValores();
        cuenta.setRoi(10.0);
        cuenta.setGrossBooking(5.0);
    }

    @Test
    public void testIsIndicatorValid() {
        //Produce token recognition error en cada letra
        //Solo comprueba si es valida la expresion, no comprueba el valor de la expresion

        Assert.assertFalse(compiler.isIndicadorValido("Invalid"));
        Assert.assertFalse(compiler.isIndicadorValido("5Invalid5"));

        Assert.assertTrue(compiler.isIndicadorValido("5+5+5"));
        Assert.assertTrue(compiler.isIndicadorValido("5+5+5*4/(2-4-8+12)"));

    }

    @Test
    public void testEvaluateIndicator(){

        Assert.assertEquals(10.0, compiler.evaluarIndicador("5+5", cuenta), 0);
        Assert.assertEquals(25.0, compiler.evaluarIndicador("5*5", cuenta), 0);
        Assert.assertEquals(1.0, compiler.evaluarIndicador("5/5", cuenta), 0);
        Assert.assertEquals(55.0, compiler.evaluarIndicador("(5+5) * 5 + 5", cuenta), 0);
        Assert.assertEquals(15.0, compiler.evaluarIndicador("ROI + GROSS_BOOKING", cuenta), 0);

    }


}
