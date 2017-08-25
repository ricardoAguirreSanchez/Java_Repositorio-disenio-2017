package com.utn.repositorio;

import com.utn.model.Indicador;

import javax.persistence.EntityManager;

/**
 * Created by nicolaslamas on 25/08/17.
 */
public class Indicadores extends Repositorio {

    public Indicadores(EntityManager em) {
        super(em);
    }

    public Indicador buscarPorId(Long id) {
        return em.find(Indicador.class, id);
    }

    public void persistir(Indicador indicador) {
        em.getTransaction().begin();
        em.persist(indicador);
        em.getTransaction().commit();
    }
}
