package com.utn.writer;

import com.utn.model.CuentaValorToWrite;
import com.utn.model.CuentaValores;
import com.utn.repositorio.Cuentas;
import com.utn.repositorio.CuentasValores;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by nicolaslamas on 18/11/17.
 */
@Component
public class CuentaValorWriter implements ItemWriter<CuentaValorToWrite> {

    private static final Logger log = LoggerFactory.getLogger(CuentaValorWriter.class);

    @Autowired
    private Cuentas cuentas;

    @Autowired
    private CuentasValores cuentasValores;

    @Override
    public void write(List<? extends CuentaValorToWrite> values) throws Exception {
        log.info("Starting to load chunk into database");
        values.forEach( cv -> {
            if(cv.exists()) updateCuentaValor(cv);
            else createCuentaValor(cv);
        });
    }

    private void updateCuentaValor(CuentaValorToWrite cv) {
        CuentaValores updatedCV = cuentasValores.findOne(cv.getId());
        updatedCV.setFechaInicio(cv.getFechaInicio());
        updatedCV.setFechaFin(cv.getFechaFin());
        updatedCV.setCost(cv.getCost());
        updatedCV.setGrossBooking(cv.getGrossBooking());
        updatedCV.setRoi(cv.getRoi());
        updatedCV.setProfit(cv.getProfit());
        updatedCV.setCuenta(cuentas.findOne(cv.getCuentaId()));
        cuentasValores.save(updatedCV);
        log.info("Succesfully updated new CuentaValores: "+updatedCV.toString());

    }

    private void createCuentaValor(CuentaValorToWrite cv) {
        CuentaValores nuevaCv = new CuentaValores();
        nuevaCv.setProfit(cv.getProfit());
        nuevaCv.setRoi(cv.getRoi());
        nuevaCv.setGrossBooking(cv.getGrossBooking());
        nuevaCv.setCost(cv.getCost());
        nuevaCv.setFechaInicio(cv.getFechaInicio());
        nuevaCv.setFechaFin(cv.getFechaFin());
        nuevaCv.setCuenta(cuentas.findOne(cv.getCuentaId()));
        cuentasValores.save(nuevaCv);
        log.info("Succesfully created new CuentaValores: "+nuevaCv.toString());

    }
}
