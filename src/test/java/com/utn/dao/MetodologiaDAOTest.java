package com.utn.dao;

import com.utn.indicadores.IndicadorCompiler;
import com.utn.model.Metodologia;
import com.utn.repositorio.Repositorio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nicolaslamas on 06/09/17.
 */
public class MetodologiaDAOTest {
    private MetodologiaDAO metodologiaDAO;
    private Repositorio repositorio;
    private static final int CANTIDAD_METODOLOGIAS_ARCHIVO = 1;

    @Before
    public void setup(){
        repositorio = new Repositorio("DDS_TEST");
        metodologiaDAO = new MetodologiaDAO(repositorio);
    }

    @Test
    public void crearMetodologia(){
        Metodologia metodologia1 = new Metodologia();
        metodologia1.setNombre("metodologia1");
        Metodologia metodologia2 = new Metodologia();
        metodologia2.setNombre("metodologia2");
        Metodologia metodologia3 = new Metodologia();
        metodologia3.setNombre("metodologia3");

        metodologiaDAO.setMetodologia(metodologia1);
        metodologiaDAO.setMetodologia(metodologia2);
        metodologiaDAO.setMetodologia(metodologia3);
        Assert.assertEquals(3 + CANTIDAD_METODOLOGIAS_ARCHIVO, metodologiaDAO.getMetodologias().size());
    }

}
