package com.utn.dao;

import com.utn.model.Indicador;
import com.utn.indicadores.IndicadorCompiler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nicolas on 22/05/17.
 */
public class IndicadorDAOTest {

    //TODO arreglar este test.
    private IndicadorDAO indicadores;

    @Before
    public void before(){
         indicadores = new IndicadorDAO();

    }

    @Test
    public void leerIndicadoresTest(){
        System.out.println(indicadores.getIndicadores());
        Assert.assertEquals(4, indicadores.getIndicadores().size());
    }

    @Test
    public void indicadorCargadoValido(){
        IndicadorCompiler compiler =  new IndicadorCompiler();
        for(Indicador indicador: indicadores.getIndicadores()){
            System.out.println(indicador);
            Assert.assertTrue(compiler.isIndicadorValido(indicador.getExpresion()));
        }
    }
}
