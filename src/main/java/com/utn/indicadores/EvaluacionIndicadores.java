package com.utn.indicadores;

import com.utn.model.*;
import com.utn.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolaslamas on 20/11/17.
 */
@Component
public class EvaluacionIndicadores {

    private final IndicadoresAplicados indicadoresAplicados;
    private final IndicadorCompiler indicadorCompiler;
    private final Indicadores indicadores;
    private final Cuentas cuentas;
    private final Empresas empresas;
    private final Usuarios usuarios;
    private final CuentasValores cuentasValores;

    @Autowired
    public EvaluacionIndicadores(IndicadoresAplicados indicadoresAplicados, IndicadorCompiler indicadorCompiler,
                                 Indicadores indicadores, Cuentas cuentas, Empresas empresas,
                                 Usuarios usuarios, CuentasValores cuentasValores) {
        this.indicadoresAplicados = indicadoresAplicados;
        this.indicadorCompiler = indicadorCompiler;
        this.indicadores = indicadores;
        this.cuentas = cuentas;
        this.empresas = empresas;
        this.usuarios = usuarios;
        this.cuentasValores = cuentasValores;
    }

    private void applyAndSave(Cuenta cuenta, Indicador indicador, CuentaValores cv) {
        IndicadorAplicado ia = new IndicadorAplicado();
        ia.setCuenta(cuenta);
        ia.setIndicador(indicador);
        ia.setValor(indicadorCompiler.evaluarIndicador(indicador.getExpresion(), cv));
        indicadoresAplicados.save(ia);
    }

    public void dropAllIndicadoresAplicados() {
        indicadoresAplicados.deleteAll();
    }

    public void evaluateAll() {
        usuarios.findAll().forEach(usuario -> {
            List<Indicador> indicadoresUsuario = indicadores.findByUsuarioId(usuario.getId());
            List<Empresa> empresasUsuario = empresas.findByUsuarioId(usuario.getId());
            List<Cuenta> cuentasEmpresas = new ArrayList<>();
            empresasUsuario.forEach(em -> cuentasEmpresas.addAll(cuentas.findByEmpresaId(em.getId())));
            cuentasEmpresas.forEach(cuenta -> {
                List<CuentaValores> cuentaValores = cuentasValores.findCuentaValoresByCuentaId(cuenta.getId());
                indicadoresUsuario.forEach(indicador ->
                        cuentaValores.forEach(cv -> applyAndSave(cuenta, indicador, cv)));});
        });
    }

    public void evaluateSingle(String userId, String nombre, String expresion) {

        Indicador indicador = new Indicador();
        indicador.setNombre(nombre);
        indicador.setExpresion(expresion);

        Usuario usuario = usuarios.findOne(Long.valueOf(userId));
        List<Empresa> empresasUsuario = empresas.findByUsuarioId(usuario.getId());
        List<Cuenta> cuentasEmpresas = new ArrayList<>();
        empresasUsuario.forEach(em -> cuentasEmpresas.addAll(cuentas.findByEmpresaId(em.getId())));

        cuentasEmpresas.forEach(cuenta -> {
            List<CuentaValores> cuentaValores = cuentasValores.findCuentaValoresByCuentaId(cuenta.getId());
                    cuentaValores.forEach(cv -> applyAndSave(cuenta, indicador, cv));});
    }
}
