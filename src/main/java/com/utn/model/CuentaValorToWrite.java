package com.utn.model;

import com.utn.model.Cuenta;
import com.utn.model.CuentaValores;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by nicolaslamas on 18/11/17.
 */
public class CuentaValorToWrite {

    private Boolean exists;
    private long id;
    private Date fechaInicio;
    private Date fechaFin;
    private Double roi;
    private Double grossBooking;
    private Double profit;
    private Double cost;
    private long cuentaId;

    public CuentaValorToWrite(long id, Date fechaInicio, Date fechaFin, Double roi, Double grossBooking, Double profit, Double cost, long cuentaId) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.roi = roi;
        this.grossBooking = grossBooking;
        this.profit = profit;
        this.cost = cost;
        this.cuentaId = cuentaId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getRoi() {
        return roi;
    }

    public void setRoi(Double roi) {
        this.roi = roi;
    }

    public Double getGrossBooking() {
        return grossBooking;
    }

    public void setGrossBooking(Double grossBooking) {
        this.grossBooking = grossBooking;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public long getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(long cuentaId) {
        this.cuentaId = cuentaId;
    }

    public Boolean exists(){
        return exists;
    }
    public void setExists(Boolean e){
        this.exists = e;
    }
}
