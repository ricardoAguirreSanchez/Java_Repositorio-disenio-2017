package com.utn.dao;

/**
 * Created by nicolas on 22/05/17.
 */
public class IndicadorDAOTest {

    private IndicadorDAO indicadorDAO;
    private static final int CANTIDAD_INDICADORES_ARCHIVO = 4;

  /*  @Before
    public void setup(){
        repositorio = new Repositorio("DDS_TEST");
        indicadorDAO = new IndicadorDAO(repositorio);
    }

    @Test
    public void crearIndicador(){
        indicadorDAO.addIndicador("Indicador1", "GROSS_BOOKING - COST");
        indicadorDAO.addIndicador("Indicador2", "COST * 1.5");
        indicadorDAO.addIndicador("Indicador3", "GROSS_BOOKING - COST + COST");
        indicadorDAO.addIndicador("Indicador4", "GROSS_BOOKING *5");

        Assert.assertEquals(4 + CANTIDAD_INDICADORES_ARCHIVO, indicadorDAO.getIndicadores().size());
    }

    @Test
    public void indicadorCargadoValido(){
        IndicadorCompiler compiler =  new IndicadorCompiler();
        indicadorDAO.getIndicadores().forEach(indicador ->
                Assert.assertTrue(compiler.isIndicadorValido(indicador.getExpresion())));
    }
*/

}
