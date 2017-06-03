package com.utn.model;

import org.springframework.stereotype.Component;

import java.util.StringJoiner;

/**
 * Created by nicolas on 22/05/17.
 */
@Component
public class Indicador {


    private String nombre;
    private String expresion;


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
