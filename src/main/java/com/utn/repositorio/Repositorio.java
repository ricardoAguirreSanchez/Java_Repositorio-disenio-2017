package com.utn.repositorio;

/**
 * Created by nicolaslamas on 16/08/17.
 */
import javax.persistence.EntityManager;

public class Repositorio {

    private Usuarios usuarios;
    private Empresas empresas;
    private Cuentas cuentas;
    private Indicadores indicadores;
    private Metodologias metodologias;

    protected EntityManager em;

    public Repositorio(EntityManager em) {
        this.em = em;
    }

    public Usuarios usuarios() {
        if (usuarios == null) {
            usuarios = new Usuarios(em);
        }
        return usuarios;
    }

    public Empresas empresas() {
        if (empresas == null) {
            empresas = new Empresas(em);
        }
        return empresas;
    }

    public Cuentas cuentas() {
        if (cuentas == null) {
            cuentas = new Cuentas(em);
        }
        return cuentas;
    }

    public Indicadores indicadores() {
        if (indicadores == null) {
            indicadores = new Indicadores(em);
        }
        return indicadores;
    }

    public Metodologias metodologias() {
        if (metodologias == null) {
            metodologias = new Metodologias(em);
        }
        return metodologias;
    }

    public void cerrar(){
        em.close();
    }
}