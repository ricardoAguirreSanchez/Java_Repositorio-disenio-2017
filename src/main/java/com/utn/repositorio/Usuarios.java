package com.utn.repositorio;

/**
 * Created by nicolaslamas on 16/08/17.
 */
import com.utn.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class Usuarios extends Repositorio {

    public Usuarios(EntityManager em) {
        super();
        this.em = em;
    }

    public Usuario buscarPorId(Long id) {
        return em.find(Usuario.class, id);
    }

    public Usuario buscarPorUserAndPassword(String user, String password){
        Usuario userResult = (Usuario) em.createQuery("SELECT u FROM Usuario u where u.mail = ? and u.password = ?")
                .setParameter(0, user)
                .setParameter(1, password)
                .getSingleResult();
        return userResult;
    }
    
    public void persistir(Usuario usuario) {
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
    }

    public List<Usuario> getUsuarios() {
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
        return query.getResultList();
    }
}



