package com.utn.model;

import javax.persistence.*;

/**
 * Created by nicolaslamas on 18/11/17.
 */
@Entity
public class InputFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "InputFile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
