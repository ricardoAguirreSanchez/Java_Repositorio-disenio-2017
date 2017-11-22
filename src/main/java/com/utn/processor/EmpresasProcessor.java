package com.utn.processor;

import com.utn.model.Cuenta;
import com.utn.model.Empresa;
import com.utn.repositorio.Cuentas;
import com.utn.repositorio.Empresas;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Created by nicolaslamas on 22/11/17.
 */
@Component
public class EmpresasProcessor {

	@Autowired
    private Empresas empresas;
	@Autowired
	private Cuentas cuentas;
	public Optional<Empresa> getEmpresaMasAntigua() {
		 return Lists.newArrayList(empresas.findAll())
                 .stream()
                 .sorted(Comparator.comparing(e -> e.getFechaCreacion().toLocalDate()))
                 .findFirst();
	}

	public Optional<Empresa> getEmpresaMejorMargen() {
        return Lists.newArrayList(empresas.findAll())
                .stream()
                .sorted(Comparator.comparing(this::getMargenTotal))
                .findFirst();
	}

	public Optional<Empresa> getEmpresaMejorRoi() {
        return Lists.newArrayList(empresas.findAll())
                .stream()
                .sorted(Comparator.comparing(this::getRoiTotal))
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
                .sorted(Comparator.comparing(e -> getCuentas(e).size()))
                .findFirst();

	}
	public Optional<Empresa> getEmpresaMaximoTotalPasivo() {
        return Lists.newArrayList(empresas.findAll())
                .stream()
                .sorted(Comparator.comparing(Empresa::getTotalPasivo))
                .findFirst();

	}


	public List<Cuenta> getCuentas(Empresa empresa) {
		return cuentas.findByEmpresaId(empresa.getId());
	}

	public Double getMargenTotal(Empresa empresa) {
		return getCuentas(empresa).stream().mapToDouble(c -> c.totalCostLastYears(10)).sum();
	}

	public Double getRoiTotal(Empresa empresa) {
		return getCuentas(empresa).stream().mapToDouble(c -> c.totalRoiLastYears(10)).sum();
	}

}
