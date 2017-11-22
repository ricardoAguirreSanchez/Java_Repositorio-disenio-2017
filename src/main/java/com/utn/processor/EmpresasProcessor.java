package com.utn.processor;

import com.utn.model.Empresa;
import com.utn.repositorio.Empresas;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.Optional;

/**
 * Created by nicolaslamas on 22/11/17.
 */
@Component
public class EmpresasProcessor {

	@Autowired
    private Empresas empresas;

	public Optional<Empresa> getEmpresaMasAntigua() {
		 return Lists.newArrayList(empresas.findAll())
                 .stream()
                 .sorted(Comparator.comparing(e -> e.getFechaCreacion().toLocalDate()))
                 .findFirst();
	}

	public Optional<Empresa> getEmpresaMejorMargen() {
        return Lists.newArrayList(empresas.findAll())
                .stream()
                .sorted(Comparator.comparing(Empresa::getMargenTotal))
                .findFirst();
	}

	public Optional<Empresa> getEmpresaMejorRoi() {
        return Lists.newArrayList(empresas.findAll())
                .stream()
                .sorted(Comparator.comparing(Empresa::getRoiTotal))
                .findFirst();
	}

	public Optional<Empresa> getEmpresaMenorDeuda() {
        return Lists.newArrayList(empresas.findAll())
                .stream()
                .sorted(Comparator.comparing(Empresa::getDeuda))
                .findFirst();
	}

	public Optional<Empresa> getEmpresaMenorCapitalContable() {
        return Lists.newArrayList(empresas.findAll())
                .stream()
                .sorted(Comparator.comparing(Empresa::getCapitalContable))
                .findFirst();
	}
    public Optional<Empresa> getEmpresaMaximaCantidadCuentas() {
        return Lists.newArrayList(empresas.findAll())
                .stream()
                .sorted(Comparator.comparing(e -> e.getCuentas().size()))
                .findFirst();

	}
	public Optional<Empresa> getEmpresaMaximoTotalPasivo() {
        return Lists.newArrayList(empresas.findAll())
                .stream()
                .sorted(Comparator.comparing(Empresa::getTotalPasivo))
                .findFirst();

	}


}
