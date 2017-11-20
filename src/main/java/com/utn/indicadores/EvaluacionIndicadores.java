package com.utn.indicadores;

import com.utn.dao.*;
import com.utn.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolaslamas on 20/11/17.
 */
@Component
public class EvaluacionIndicadores {

    private final IndicadorAplicadoDAO indicadorAplicadoDAO;
    private final IndicadorCompiler indicadorCompiler;
    private final IndicadorDAO indicadorDAO;
    private final CuentaDAO cuentaDAO;
    private final EmpresaDAO empresaDAO;
    private final UsuarioDAO usuarioDAO;
    private final CuentaValoresDAO cuentaValoresDAO;

    @Autowired
    public EvaluacionIndicadores(IndicadorAplicadoDAO indicadorAplicadoDAO, IndicadorCompiler indicadorCompiler,
                                 IndicadorDAO indicadorDAO, CuentaDAO cuentaDAO, EmpresaDAO empresaDAO,
                                 UsuarioDAO usuarioDAO, CuentaValoresDAO cuentaValoresDAO) {
        this.indicadorAplicadoDAO = indicadorAplicadoDAO;
        this.indicadorCompiler = indicadorCompiler;
        this.indicadorDAO = indicadorDAO;
        this.cuentaDAO = cuentaDAO;
        this.empresaDAO = empresaDAO;
        this.usuarioDAO = usuarioDAO;
        this.cuentaValoresDAO = cuentaValoresDAO;
    }

    private void applyAndSave(Cuenta cuenta, Indicador indicador, CuentaValores cv) {
        IndicadorAplicado ia = new IndicadorAplicado();
        ia.setCuenta(cuenta);
        ia.setIndicador(indicador);
        ia.setValor(indicadorCompiler.evaluarIndicador(indicador.getExpresion(), cv));
        indicadorAplicadoDAO.persist(ia);
    }

    public void dropAllIndicadoresAplicados() {
        indicadorAplicadoDAO.dropRows();
    }

    public void evaluateAll() {
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
    }

    public void evaluateSingle(String userId, String nombre, String expresion) {

        Indicador indicador = new Indicador();
        indicador.setNombre(nombre);
        indicador.setExpresion(expresion);

        Usuario usuario = usuarioDAO.getUsuarioById(userId);
        List<Empresa> empresasUsuario = empresaDAO.getByUserId(usuario.getId());
        List<Cuenta> cuentasEmpresas = new ArrayList<>();
        empresasUsuario.forEach(em -> cuentasEmpresas.addAll(cuentaDAO.getByEmpresaId(em.getId())));

        cuentasEmpresas.forEach(cuenta -> {
            List<CuentaValores> cuentaValores = cuentaValoresDAO.getValoresByCuentaId(cuenta.getId());
                    cuentaValores.forEach(cv -> applyAndSave(cuenta, indicador, cv));});
    }
}
