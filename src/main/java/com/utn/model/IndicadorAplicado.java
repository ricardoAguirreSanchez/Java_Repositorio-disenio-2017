package com.utn.model;

import javax.persistence.*;

/**
 * Created by nicolaslamas on 18/11/17.
 */
@Entity
public class IndicadorAplicado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "valor")
    private Double valor;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cuenta_id", referencedColumnName = "id")
    private Cuenta cuenta;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "indicador_id", referencedColumnName = "id")
    private Indicador indicador;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Indicador getIndicador() {
        return indicador;
    }

    public void setIndicador(Indicador indicador) {
        this.indicador = indicador;
    }
}
