package com.utn.metodologias;

import com.utn.dao.CatalogoReglasDAO;
import com.utn.dao.MetodologiaDAO;
import com.utn.model.Empresa;
import com.utn.model.Metodologia;
import com.utn.repositorio.Repositorio;
import com.utn.services.implementation.CatalogoReglasImplementation;
import com.utn.services.implementation.MetodologiaServiceImplementation;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by nicolaslamas on 06/09/17.
 */
public class MetodologiasTest {

    private MetodologiaDAO metodologiaDAO;
    private MetodologiaServiceImplementation metodologiaServiceImplementation;
    private Repositorio repositorio;


    @Before
    public void setup(){
        repositorio = new Repositorio("DDS_TEST");
        metodologiaDAO = new MetodologiaDAO(repositorio);
        metodologiaServiceImplementation = new MetodologiaServiceImplementation(metodologiaDAO);
    }

    @Test
    @Ignore
    public void longevidadTest(){
        List<String> listaCondiciones = new ArrayList<>();
        listaCondiciones.add("Longevidad");

        Metodologia metodologia = new Metodologia();
        metodologia.setCondiciones(listaCondiciones);

        HashMap<String, Empresa> hash = metodologiaServiceImplementation.realizaComparacion(metodologia);
        System.out.println("La empresa ganadora de Longevidad es: "+ hash.get("Longevidad").getNombre() );
    }

    @Test
    @Ignore
    public void maximizarRoeTest(){

        ArrayList<String> listaCondiciones1 = new ArrayList<>();
        listaCondiciones1.add("Maximizar ROE");

        Metodologia metodologia1 = new Metodologia();
        metodologia1.setCondiciones(listaCondiciones1);

        HashMap<String,Empresa> hash1 = metodologiaServiceImplementation.realizaComparacion(metodologia1);
        System.out.println("La empresa ganadora de Maximizar ROE es: "+ hash1.get("Maximizar ROE").getNombre() );

    }

    @Test
    @Ignore
    public void margenesDeGananciaTest(){

        ArrayList<String> listaCondiciones2 = new ArrayList<>();
        listaCondiciones2.add("Margenes de ganancia");

        Metodologia metodologia2 = new Metodologia();
        metodologia2.setCondiciones(listaCondiciones2);

        HashMap<String,Empresa> hash2 = metodologiaServiceImplementation.realizaComparacion(metodologia2);
        System.out.println("La empresa ganadora de Margenes de ganancia es: "+ hash2.get("Margenes de ganancia").getNombre() );
    }

    @Test
    @Ignore
    public void minimizarDeudaTest(){

        ArrayList<String> listaCondiciones3 = new ArrayList<>();
        listaCondiciones3.add("Minimizar deuda");

        Metodologia metodologia3 = new Metodologia();
        metodologia3.setCondiciones(listaCondiciones3);

        HashMap<String,Empresa> hash3 = metodologiaServiceImplementation.realizaComparacion(metodologia3);
        System.out.println("La empresa ganadora de Minimizar deuda es: "+ hash3.get("Minimizar deuda").getNombre() );
    }


    @Test
    @Ignore
    public void cargarMetodologiasTest(){
        CatalogoReglasDAO catalogoDAO = new CatalogoReglasDAO();
        CatalogoReglasImplementation catalogoReglas = new CatalogoReglasImplementation(catalogoDAO);
        catalogoReglas.getReglas();

        Metodologia metodologiaNueva = new Metodologia();
        metodologiaNueva.setNombre("nombre que quiero");

        ArrayList<String > listaCondicionesNuevas = new ArrayList<>();
        listaCondicionesNuevas.add("Maximizar ROE");
        listaCondicionesNuevas.add("Maxima cantidad cuentas");
        metodologiaNueva.setCondiciones(listaCondicionesNuevas);
        metodologiaServiceImplementation.setMetodologia(metodologiaNueva);

        metodologiaServiceImplementation.getMetodologias();
        System.out.println(metodologiaServiceImplementation.getMetodologias());
    }

}
