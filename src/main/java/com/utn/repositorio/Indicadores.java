package com.utn.repositorio;

import com.utn.model.Indicador;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by nicolaslamas on 25/08/17.
 */
public interface Indicadores  extends CrudRepository<Indicador, Long> {

    List<Indicador> findByUsuarioId(long usuarioId);
}
