package com.utn.dao;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nicolas on 02/04/17.
 */
public class CuentaDAOTest {

    @Test
    public void leerTodasLasCuentasTest() {

        //TODO cambiar este test a algo que sirva
        CuentaDAO cuenta = new CuentaDAO();
        Assert.assertEquals(3, cuenta.getCuentas().size());
    }

}