package com.utn.repositorio;

/**
 * Created by nicolaslamas on 16/08/17.
 */
import com.utn.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
public interface Usuarios extends CrudRepository<Usuario, Long> {

    List<Usuario> findByMailAndPassword(String mail, String password);

}



