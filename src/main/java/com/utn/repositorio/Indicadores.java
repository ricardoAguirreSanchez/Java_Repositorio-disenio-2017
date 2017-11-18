package com.utn.repositorio;

import com.utn.model.Empresa;
import com.utn.model.Indicador;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by nicolaslamas on 25/08/17.
 */
public interface Indicadores  extends CrudRepository<Indicador, Long> {

}
