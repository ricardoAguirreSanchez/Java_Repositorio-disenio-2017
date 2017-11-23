package com.utn.repositorio;

import com.utn.model.Metodologia;
import com.utn.model.Regla;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nicolaslamas on 22/11/17.
 */
public interface Reglas extends CrudRepository<Regla, Long> {
}
