package com.utn.repositorio;

import com.utn.model.Cuenta;

import javax.persistence.EntityManager;

/**
 * Created by nicolaslamas on 25/08/17.
 */
public class Cuentas extends Repositorio{

    public Cuentas(EntityManager em) {
        super(em);
    }

    public Cuenta buscarPorId(Long id) {
        return em.find(Cuenta.class, id);
    }

    public void persistir(Cuenta cuenta) {
        em.getTransaction().begin();
        em.persist(cuenta);
        em.getTransaction().commit();
    }
}
