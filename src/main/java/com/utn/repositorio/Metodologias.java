package com.utn.repositorio;

import com.utn.model.Metodologia;

import javax.persistence.EntityManager;

/**
 * Created by nicolaslamas on 25/08/17.
 */
public class Metodologias extends Repositorio {

    public Metodologias(EntityManager em) {
        super(em);
    }

    public Metodologia buscarPorId(Long id) {
        return em.find(Metodologia.class, id);
    }

    public void persistir(Metodologia metodologia) {
        em.getTransaction().begin();
        em.persist(metodologia);
        em.getTransaction().commit();
    }
}
