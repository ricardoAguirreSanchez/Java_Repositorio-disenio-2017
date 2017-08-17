package com.utn.repositorio;

/**
 * Created by nicolaslamas on 16/08/17.
 */
import com.utn.model.Usuario;

import javax.persistence.EntityManager;

public class Usuarios extends Repositorio {

    Usuarios(EntityManager em) {
        super(em);
    }

    public Usuario buscarPorId(Long id) {
        return em.find(Usuario.class, id);
    }

    public void persistir(Usuario usuario) {
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
    }
}



