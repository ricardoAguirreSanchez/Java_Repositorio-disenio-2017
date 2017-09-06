package com.utn.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.utn.model.Indicador;
import com.utn.repositorio.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class IndicadorDAO {

    private ClassLoader classLoader = getClass().getClassLoader();
    private String fileName = classLoader.getResource("indicadores.json").getFile();
    private Type jsonCuentaType = new TypeToken<List<Indicador>>(){}.getType();
    private Gson gson = new Gson();
    private Repositorio repositorio;

    @Autowired
    public IndicadorDAO(Repositorio repositorio){
        this.repositorio = repositorio;
    }

    private List<Indicador> getIndicadoresArchivo(){
        List<Indicador> indicadores = new ArrayList<>();
        try {
            JsonReader reader = new JsonReader(new FileReader(fileName));
            indicadores = gson.fromJson(reader, jsonCuentaType);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return indicadores;
    }

    private List<Indicador> getIndicadoresDB() {
        return repositorio.indicadores().getIndicadores();
    }

    public List<Indicador> getIndicadores()  {
        List<Indicador> indicadores = new ArrayList<>();
        indicadores.addAll(getIndicadoresArchivo());
        indicadores.addAll(getIndicadoresDB());
        return indicadores;
    }

    public void addIndicador(String nombre, String indicador) {
        Indicador in= new Indicador();
        in.setExpresion(indicador);
        in.setNombre(nombre);
        repositorio.indicadores().persistir(in);
    }
}

