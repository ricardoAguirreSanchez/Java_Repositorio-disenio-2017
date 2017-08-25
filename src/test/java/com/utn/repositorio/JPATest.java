package com.utn.repositorio;

import com.utn.model.Usuario;
import com.utn.repositorio.Repositorio;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

//TODO cambiar este test, para realizar pruebas de llamadas a lso metodos del repositorio.

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JPATest {
    private static final String PERSISTENCE_UNIT_NAME = "DDS";
    private EntityManagerFactory emFactory;
    private Repositorio repositorio;

    @Before
    public void setUp() throws Exception {
        emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        repositorio = new Repositorio(emFactory.createEntityManager());
    }
    @Test
    public void aPersistir() {


        List<Usuario> t = repositorio.usuarios().getUsuarios();
        int x = 0;

    }

    @After
    public void tearDown() throws Exception {
        repositorio.cerrar();
        emFactory.close();
    }
}