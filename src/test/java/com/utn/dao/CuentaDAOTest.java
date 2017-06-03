package com.utn.dao;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nicolas on 02/04/17.
 */
public class CuentaDAOTest {

    @Test
    public void leerTodasLasCuentasTest() {

        CuentaDAO cuenta = new CuentaDAO();
        System.out.println(cuenta.getCuentas().get(0).toString());
        Assert.assertEquals(2, cuenta.getCuentas().size());
    }

}