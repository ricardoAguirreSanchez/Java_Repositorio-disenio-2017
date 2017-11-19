package com.utn.indicadores;

import com.utn.batch.BatchCuentasConfiguration;
import com.utn.dao.*;
import com.utn.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolaslamas on 18/11/17.
 */
@Component
public class EvaluacionIndicadoresScheduled {

    private final IndicadorDAO indicadorDAO;
    private final CuentaDAO cuentaDAO;
    private final EmpresaDAO empresaDAO;
    private final UsuarioDAO usuarioDAO;
    private final IndicadorAplicadoDAO indicadorAplicadoDAO;
    private final IndicadorCompiler indicadorCompiler;
    private final CuentaValoresDAO cuentaValoresDAO;


    private static final Logger log = LoggerFactory.getLogger(BatchCuentasConfiguration.class);


    @Autowired
    public EvaluacionIndicadoresScheduled(IndicadorDAO indicadorDAO, CuentaDAO cuentaDAO, EmpresaDAO empresaDAO,
                                          UsuarioDAO usuarioDAO, IndicadorAplicadoDAO indicadorAplicadoDAO,
                                          IndicadorCompiler indicadorCompiler, CuentaValoresDAO cuentaValoresDAO) {
        this.indicadorDAO = indicadorDAO;
        this.cuentaDAO = cuentaDAO;
        this.empresaDAO = empresaDAO;
        this.usuarioDAO = usuarioDAO;
        this.indicadorAplicadoDAO = indicadorAplicadoDAO;
        this.indicadorCompiler = indicadorCompiler;
        this.cuentaValoresDAO = cuentaValoresDAO;
    }


    @PostConstruct
    public void evaluarIndicadores(){

        log.info("Starting to pre load indicators");
        indicadorAplicadoDAO.dropRows();
        usuarioDAO.getUsuarios().forEach(usuario -> {
                List<Indicador> indicadoresUsuario = indicadorDAO.getByUserId(usuario.getId());
                List<Empresa> empresasUsuario = empresaDAO.getByUserId(usuario.getId());
                List<Cuenta> cuentasEmpresas = new ArrayList<>();
                empresasUsuario.forEach(em -> cuentasEmpresas.addAll(cuentaDAO.getByEmpresaId(em.getId())));
                cuentasEmpresas.forEach(cuenta -> {
                    List<CuentaValores> cuentaValores = cuentaValoresDAO.getValoresByCuentaId(cuenta.getId());
                    indicadoresUsuario.forEach(indicador ->
                            cuentaValores.forEach(cv -> applyAndSave(cuenta, indicador, cv)));});
        });
        log.info("Finished pre loading indicators");


    }

    private void applyAndSave(Cuenta cuenta, Indicador indicador, CuentaValores cv) {
        IndicadorAplicado ia = new IndicadorAplicado();
        ia.setCuenta(cuenta);
        ia.setIndicador(indicador);
        ia.setValor(indicadorCompiler.evaluarIndicador(indicador.getExpresion(), cv));
        indicadorAplicadoDAO.persist(ia);

    }
}
