package com.utn.dao;

import com.utn.model.Empresa;
import com.utn.repositorio.Repositorio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

/**
 * Created by nicolaslamas on 06/09/17.
 */

//@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class EmpresaDAOTest {

  /*  @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private EmpresaDAO empresaDAO;

    @Test
    public void crearEmpresa() {

        Empresa empresa1 = new Empresa();
        empresa1.setNombre("Empresa1");
        empresa1.setFechaCreacion(Date.valueOf("1994-1-3"));
        Empresa empresa2 = new Empresa();
        empresa2.setNombre("Empresa2");
        empresa2.setFechaCreacion(Date.valueOf("1994-1-3"));
        Empresa empresa3 = new Empresa();
        empresa3.setNombre("Empresa3");
        empresa3.setFechaCreacion(Date.valueOf("1994-1-3"));
        Empresa empresa4 = new Empresa();
        empresa4.setNombre("Empresa4");
        empresa4.setFechaCreacion(Date.valueOf("1994-1-3"));

        empresaDAO.addEmpresa(empresa1);
        empresaDAO.addEmpresa(empresa2);
        empresaDAO.addEmpresa(empresa3);
        empresaDAO.addEmpresa(empresa4);

        Assert.assertEquals(4 + 3, empresaDAO.getEmpresas().size());
    } */
}
