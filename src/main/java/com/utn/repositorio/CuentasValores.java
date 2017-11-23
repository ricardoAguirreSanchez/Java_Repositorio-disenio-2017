package com.utn.repositorio;

import com.utn.model.CuentaValores;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by nicolaslamas on 18/11/17.
 */
public interface CuentasValores extends CrudRepository<CuentaValores, Long> {
    List<CuentaValores> findCuentaValoresByCuentaId(long cuentaId);

    CuentaValores findCuentaValoresByCuentaIdAndFechaInicioAndFechaFin(Long cuentaId, Date fechaInicio, Date fechaFin);

}
