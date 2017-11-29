package com.utn.model;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.util.Arrays;

/**
 * Created by nicolaslamas on 28/11/17.
 */
public class CuentaTest {


    @Test
    public void testTotalCostLastYears() {
        Cuenta cuenta = new Cuenta();
        CuentaValores cv1 = new CuentaValores();
        cv1.setFechaFin(Date.valueOf("2016-06-06"));
        cv1.setCost(10.0);
        CuentaValores cv2 = new CuentaValores();
        cv2.setFechaFin(Date.valueOf("2015-06-06"));
        cv2.setCost(10.0);
        cuenta.setCuentaValores(Arrays.asList(cv1, cv2));
        Assert.assertEquals(Double.valueOf(20.0), cuenta.totalCostLastYears());
    }

    @Test
    public void totalRoiLastYeas() {
        Cuenta cuenta = new Cuenta();
        CuentaValores cv1 = new CuentaValores();
        cv1.setFechaFin(Date.valueOf("2016-06-06"));
        cv1.setRoi(10.0);
        CuentaValores cv2 = new CuentaValores();
        cv2.setFechaFin(Date.valueOf("2015-06-06"));
        cv2.setRoi(10.0);
        cuenta.setCuentaValores(Arrays.asList(cv1, cv2));
        Assert.assertEquals(Double.valueOf(20.0), cuenta.totalRoiLastYears());
    }

}
