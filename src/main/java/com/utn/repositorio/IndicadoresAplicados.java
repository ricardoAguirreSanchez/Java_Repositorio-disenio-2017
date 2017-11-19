package com.utn.repositorio;

import com.utn.model.IndicadorAplicado;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nicolaslamas on 18/11/17.
 */
public interface IndicadoresAplicados extends CrudRepository<IndicadorAplicado, Long> {
    IndicadorAplicado findByCuentaIdAndIndicadorIdAndCuentaValorId(long cuentaId, long indicadorId, long cuentaValorId);
}
