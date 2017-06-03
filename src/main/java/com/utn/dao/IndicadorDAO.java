package com.utn.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.utn.model.Indicador;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolas on 22/05/17.
 */
@Component
public class IndicadorDAO {

        private ClassLoader classLoader = getClass().getClassLoader();
        private String fileName = classLoader.getResource("indicadores.json").getFile();
        private Type jsonCuentaType = new TypeToken<List<Indicador>>(){}.getType();
        private Gson gson = new Gson();

        private List<Indicador> indicadores = generateIndicadores();

        private List<Indicador> generateIndicadores(){
            List<Indicador> indicadores = new ArrayList<Indicador>();
            try {
                JsonReader reader = new JsonReader(new FileReader(fileName));
                indicadores = gson.fromJson(reader, jsonCuentaType);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return indicadores;
        }

        public List<Indicador> getIndicadores()  {
          return indicadores;
        }

    public void agregarIndicador(String nombre, String indicador) {
            Indicador in= new Indicador();
            in.setExpresion(indicador);
            in.setNombre(nombre);
            indicadores.add(in);

    }
}

