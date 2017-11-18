package com.utn.repositorio;

import com.utn.model.Metodologia;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by nicolaslamas on 25/08/17.
 */
public interface Metodologias  extends CrudRepository<Metodologia, Long> {

/*
    public Metodologias(EntityManager em) {
        super();
        this.em = em;
    }

    public Metodologia buscarPorId(Long id) {
        return em.find(Metodologia.class, id);
    }

    public void persistir(Metodologia metodologia) {
        em.getTransaction().begin();
        em.persist(metodologia);
        em.getTransaction().commit();
    }

    public List<Metodologia> getMetodologias() {
        TypedQuery<Metodologia> query = em.createQuery("SELECT u FROM Metodologia u", Metodologia.class);
        return query.getResultList();
    } */
}
