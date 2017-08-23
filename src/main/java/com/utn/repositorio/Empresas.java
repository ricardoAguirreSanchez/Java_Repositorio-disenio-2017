package com.utn.repositorio;

import com.utn.model.Empresa;
import com.utn.model.Usuario;

import javax.persistence.EntityManager;

/**
 * Created by nicolaslamas on 23/08/17.
 */
public class Empresas  extends Repositorio {

    Empresas(EntityManager em) {
        super(em);
    }

    public Empresa buscarPorId(Long id) {
        return em.find(Empresa.class, id);
    }

    public void persistir(Empresa empresa) {
        em.getTransaction().begin();
        em.persist(empresa);
        em.getTransaction().commit();
    }
}



