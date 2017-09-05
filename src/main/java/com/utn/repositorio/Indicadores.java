package com.utn.repositorio;

import com.utn.model.Empresa;
import com.utn.model.Indicador;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public List<Indicador> getIndicadores() {
        TypedQuery<Indicador> query = em.createQuery("SELECT u FROM Indicador u", Indicador.class);
        return query.getResultList();
    }
}
