package com.utn.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by nicolaslamas on 16/08/17.
 */
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String apellido;
    @NotNull
    private String mail;
    @NotNull
    private String password;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Indicador> indicadores;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Metodologia> metodologias;

    public Usuario() {}

    public Usuario(String nombre, String apellido, String mail, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
