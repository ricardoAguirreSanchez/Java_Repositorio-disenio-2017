package com.utn.dao;

import com.utn.model.Cuenta;
import com.utn.repositorio.Repositorio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nicolas on 02/04/17.
 */
public class CuentaDAOTest {

    private CuentaDAO cuentaDAO;
    private Repositorio repositorio;
    private static final int CANTIDAD_CUENTAS_ARCHIVO = 1;
    
    @Before
    public void setup(){
        repositorio = new Repositorio("DDS_TEST");
        cuentaDAO = new CuentaDAO(repositorio);
    }

    @Test
    public void crearLeerCuenta() {

        Cuenta cuenta1 = new Cuenta();
        cuenta1.setTipoCuenta("cuenta1");
        Cuenta cuenta2 = new Cuenta();
        cuenta1.setTipoCuenta("cuenta2");
        Cuenta cuenta3 = new Cuenta();
        cuenta1.setTipoCuenta("cuenta3");
        Cuenta cuenta4 = new Cuenta();
        cuenta1.setTipoCuenta("cuenta4");
        Cuenta cuenta5 = new Cuenta();
        cuenta1.setTipoCuenta("cuenta5");

        cuentaDAO.addCuenta(cuenta1);
        cuentaDAO.addCuenta(cuenta2);
        cuentaDAO.addCuenta(cuenta3);
        cuentaDAO.addCuenta(cuenta4);
        cuentaDAO.addCuenta(cuenta5);

        Assert.assertEquals(5 + CANTIDAD_CUENTAS_ARCHIVO, cuentaDAO.getCuentas().size());
    }
}