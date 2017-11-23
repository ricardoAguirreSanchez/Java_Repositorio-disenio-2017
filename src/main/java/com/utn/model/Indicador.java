package com.utn.model;

import javax.persistence.*;
import java.util.StringJoiner;

/**
 * Created by nicolas on 22/05/17.
 */
@Entity
public class Indicador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String expresion;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    public String getExpresion() {return expresion;}

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    @Override
    public String toString() {

        return new StringJoiner(", ", Indicador.class.getSimpleName() + "{", "}")
                .add("nombre= " + nombre)
                .add("expresion= " + expresion)
                .toString();
    }
}
