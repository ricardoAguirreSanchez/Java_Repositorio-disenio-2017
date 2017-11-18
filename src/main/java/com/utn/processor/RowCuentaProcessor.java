package com.utn.processor;

/**
 * Created by nicolaslamas on 18/11/17.
 */

import com.utn.model.CuentaValorToWrite;
import com.utn.model.CuentaValores;
import com.utn.model.RowCuenta;
import com.utn.repositorio.CuentasValores;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;


public class RowCuentaProcessor implements ItemProcessor<RowCuenta, CuentaValorToWrite> {

    private static final Logger log = LoggerFactory.getLogger(RowCuentaProcessor.class);

    @Autowired
    private CuentasValores cuentasValores;

    @Override
    public CuentaValorToWrite process(final RowCuenta row) throws Exception {

        Long idCuentaValor = getIdCuentaValor(row.getId(), row.getFechaInicio(), row.getFechaFin());

        CuentaValorToWrite cvr = new CuentaValorToWrite(idCuentaValor, Date.valueOf(row.getFechaInicio()), Date.valueOf(row.getFechaFin()),
                Double.valueOf(row.getRoi()), Double.valueOf(row.getGrossBooking()), Double.valueOf(row.getProfit()),
                Double.valueOf(row.getCost()), Long.valueOf(row.getId()));

        cvr.setExists(idCuentaValor != 0L);
        return cvr;
    }

    private Long getIdCuentaValor(String id, String fechaInicio, String fechaFin) {
       CuentaValores cv =  cuentasValores.findCuentaValoresByCuentaIdAndFechaInicioAndFechaFin(Long.valueOf(id),
               Date.valueOf(fechaInicio), Date.valueOf(fechaFin));
        return cv == null ? 0L : cv.getId();
    }
}