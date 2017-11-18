package com.utn.repositorio;

import com.utn.model.Cuenta;
import com.utn.model.CuentaValores;
import com.utn.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by nicolaslamas on 18/11/17.
 */
public interface CuentasValores extends CrudRepository<CuentaValores, Long> {
    List<CuentaValores> findCuentaValoresByCuentaId(long cuentaId);

    CuentaValores findCuentaValoresByCuentaIdAndFechaInicioAndFechaFin(Long cuentaId, Date fechaInicio, Date fechaFin);

}
