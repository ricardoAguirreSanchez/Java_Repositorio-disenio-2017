package com.utn.model;

import javax.persistence.*;

/**
 * Created by nicolaslamas on 22/11/17.
 */
@Entity
public class Regla {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "regla")
    private String regla;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRegla() {
        return regla;
    }

    public void setRegla(String regla) {
        this.regla = regla;
    }
}
