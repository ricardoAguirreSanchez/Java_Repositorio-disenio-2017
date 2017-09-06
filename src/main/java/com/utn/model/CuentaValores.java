package com.utn.model;

import com.utn.indicadores.resolver.NumericVariableResolver;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringJoiner;

/**
 * Created by nicolas on 22/05/17.
 */

@Component
@Entity
@Table(name = "CUENTA_VALORES")
public class CuentaValores implements NumericVariableResolver {

    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "fecha_inicio")
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    private Date fechaFin;
    private Double roi;
    @Column(name = "gross_booking")
    private Double grossBooking;
    private Double profit;
    private Double cost;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cuenta_id", referencedColumnName = "id")
    private Cuenta cuenta;

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

    @Override
    public Double getRoi() {
        return roi;
    }

    public void setRoi(Double roi) {
        this.roi = roi;
    }

    @Override
    public Double getGrossBooking() {
        return grossBooking;
    }

    public void setGrossBooking(Double grossBooking) {
        this.grossBooking = grossBooking;
    }

    @Override
    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    @Override
    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {

        return new StringJoiner(", ", CuentaValores.class.getSimpleName() + "{", "}")
                .add("fechaInicio= " + formatter.format(fechaInicio))
                .add("fechaFin= " + formatter.format(fechaFin))
                .add("roi= " + roi)
                .add("grossBooking= " + grossBooking)
                .add("profit= " + profit)
                .add("cost= " + cost)
                .toString();
    }
}
