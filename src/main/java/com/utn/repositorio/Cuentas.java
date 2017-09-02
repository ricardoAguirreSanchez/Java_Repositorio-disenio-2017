package com.utn.repositorio;

import com.utn.model.Cuenta;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

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
    public List<Cuenta> getCuentas() {
        TypedQuery<Cuenta> query = em.createQuery("SELECT u FROM Cuenta u", Cuenta.class);
        return query.getResultList();
    }
}