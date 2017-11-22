package com.utn.repositorio;

import com.utn.model.Empresa;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by nicolaslamas on 23/08/17.
 */
public interface Empresas  extends CrudRepository<Empresa, Long>{
    List<Empresa> findByUsuarioId(long usuarioId);
}



