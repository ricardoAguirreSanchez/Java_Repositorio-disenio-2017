package com.utn.repositorio;

import com.utn.model.Empresa;
import com.utn.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by nicolaslamas on 23/08/17.
 */
public interface Empresas  extends CrudRepository<Empresa, Long>{
}



