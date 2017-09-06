package com.utn.repositorio;

/**
 * Created by nicolaslamas on 16/08/17.
 */
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@Component
public class Repositorio {

    private Usuarios usuarios;
    private Empresas empresas;
    private Cuentas cuentas;
    private Indicadores indicadores;
    private Metodologias metodologias;
    protected EntityManager em;
    private String dbInstance;


    public Repositorio(){
        this.dbInstance = "DDS";
    }

    public Repositorio(String nombreDB) {
        this.dbInstance = nombreDB;
    }

    public Usuarios usuarios() {
        if (usuarios == null) {
            usuarios = new Usuarios(getEntityManager());
        }
        return usuarios;
    }

    public Empresas empresas() {
        if (empresas == null) {
            empresas = new Empresas(getEntityManager());
        }
        return empresas;
    }

    public Cuentas cuentas() {
        if (cuentas == null) {
            cuentas = new Cuentas(getEntityManager());
        }
        return cuentas;
    }

    public Indicadores indicadores() {
        if (indicadores == null) {
            indicadores = new Indicadores(getEntityManager());
        }
        return indicadores;
    }

    public Metodologias metodologias() {
        if (metodologias == null) {
            metodologias = new Metodologias(getEntityManager());
        }
        return metodologias;
    }

    public void cerrar(){
        this.em.close();
    }

    public EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory(this.dbInstance).createEntityManager();
    }
}