package com.utn.repositorio;

import com.utn.model.Cuenta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by nicolaslamas on 25/08/17.
 */
public interface Cuentas extends CrudRepository<Cuenta, Long>{

    List<Cuenta> findByEmpresaId(long empresaId);
}
