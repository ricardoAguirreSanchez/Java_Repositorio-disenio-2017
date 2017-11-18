package com.utn.dao;

import com.utn.model.Cuenta;
import com.utn.repositorio.Cuentas;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by nicolas on 02/04/17.
 */

//@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class CuentaDAOTest {
/*
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private Cuentas cuentaDAO;

    @Test
    public void testCrear() throws Exception {

        Cuenta cuenta1 = new Cuenta();
        cuenta1.setTipoCuenta("cuenta1");
        Cuenta cuenta2 = new Cuenta();
        cuenta1.setTipoCuenta("cuenta2");

        cuentaDAO.save(cuenta1);
        cuentaDAO.save(cuenta2);

        List<Cuenta> cuentas = Lists.newArrayList(cuentaDAO.findAll());
        assertThat(true);
    }
*/
}