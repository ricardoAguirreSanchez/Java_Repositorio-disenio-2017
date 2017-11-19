package com.utn.dao;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.utn.model.Empresa;
import com.utn.repositorio.Empresas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmpresaDAO {

	private ClassLoader classLoader = getClass().getClassLoader();
	private String fileName = classLoader.getResource("empresas.json").getFile();
	private Type jsonEmpresaType = new TypeToken<List<Empresa>>() {}.getType();

	//El setDateFormat permite parsear a tipo Date, se puede buscar como usar otro tipo de dato también
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

	@Autowired
	private Empresas empresas;

	@Autowired
	private CuentaDAO cuentaDAO;

	public EmpresaDAO( ){
			}

	public List<Empresa> getEmpresas() {
		List<Empresa> listaEmpresas = new ArrayList<>();
		listaEmpresas.addAll(getEmpresasArchivo());
		listaEmpresas.addAll(getEmpresasDB());
		return listaEmpresas;
	}

	private List<Empresa> getEmpresasDB() {
		return Lists.newArrayList(empresas.findAll());
	}

	private List<Empresa> getEmpresasArchivo() {
		List<Empresa> listaEmpresas = new ArrayList<>();
		try {
			JsonReader reader = new JsonReader(new FileReader(fileName));
			listaEmpresas = gson.fromJson(reader, jsonEmpresaType);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaEmpresas;
	}
/*
	//devuelve la empresa mas antigua o null
	public Empresa getEmpresaMasAntigua() {
		List<Empresa> listaEmpresas = this.getEmpresas();
		Empresa empresaGanadora = listaEmpresas.get(0);
		for (Empresa unaEmpresa : listaEmpresas) {
			if (unaEmpresa.getFechaCreacion().getYear() < empresaGanadora.getFechaCreacion().getYear()) {
				empresaGanadora = unaEmpresa;
			}
		}


		//Fecha actual desglosada:
		Calendar fecha = Calendar.getInstance();
		int anioActual = fecha.get(Calendar.YEAR);

		//Verifico que la mas antigua sea de 10 anos como minimo
		if (empresaGanadora.getFechaCreacion().getYear() + 10 > anioActual) {
			empresaGanadora = null;
		}
		return empresaGanadora;

	}

	//Busca la empresa conun mejor margen=totalPasivo - cost
	public Empresa getEmpresaMejorMargen() {

		List<Empresa> listaEmpresas = this.getEmpresas();
		Empresa empresaGanadora = listaEmpresas.get(0);

		//Fecha actual desglosada:
		Calendar fecha = Calendar.getInstance();
		int anioActual = fecha.get(Calendar.YEAR);

		for (Empresa unaEmpresa : listaEmpresas) {
			if (obtenerMargenTotal(unaEmpresa) > obtenerMargenTotal(empresaGanadora)) {
				empresaGanadora = unaEmpresa;
			}
		}

		return empresaGanadora;

	}

	//devuelve la empresa con mejor ROE en los ultimos 10 años
	public Empresa getEmpresaMejorROE() {

		List<Empresa> listaEmpresas = this.getEmpresas();
		Empresa empresaGanadora = listaEmpresas.get(0);

		// Fecha actual desglosada:
		Calendar fecha = Calendar.getInstance();
		int anioActual = fecha.get(Calendar.YEAR);

		for (Empresa unaEmpresa : listaEmpresas) {
			if (obtenerROETotal(unaEmpresa) > obtenerROETotal(empresaGanadora)) {
				empresaGanadora = unaEmpresa;
			}
		}

		return empresaGanadora;

	}

	//devuelve la empresa con menor deuda
	public Empresa getEmpresaMenorDeuda() {

		List<Empresa> listaEmpresas = this.getEmpresas();
		Empresa empresaGanadora = listaEmpresas.get(0);
		Double deuda = empresaGanadora.getTotalPasivo() / empresaGanadora.getCapitalContable();
		for (Empresa unaEmpresa : listaEmpresas) {
			if (deuda > (unaEmpresa.getTotalPasivo() / unaEmpresa.getCapitalContable())) {
				empresaGanadora = unaEmpresa;
			}
		}

		return empresaGanadora;

	}


	//devuelve la empresa con menor capital contable
	public Empresa getEmpresaMenorCapitalContable() {

		List<Empresa> listaEmpresas = this.getEmpresas();
		Empresa empresaGanadora = listaEmpresas.get(0);
		for (Empresa unaEmpresa : listaEmpresas) {
			if (empresaGanadora.getCapitalContable() > unaEmpresa.getCapitalContable()) {
				empresaGanadora = unaEmpresa;
			}
		}

		return empresaGanadora;

	}


	//devuelve la empresa con maxima cantidad cuentas
	public Empresa getEmpresaMaximaCantidadCuentas() {

		List<Empresa> listaEmpresas = this.getEmpresas();
		Empresa empresaGanadora = listaEmpresas.get(0);
		for (Empresa unaEmpresa : listaEmpresas) {
			if (empresaGanadora.getListaIdCuentas().size() < unaEmpresa.getListaIdCuentas().size()) {
				empresaGanadora = unaEmpresa;
			}
		}

		return empresaGanadora;

	}

	//devuelve la empresa con el total pasivo maximo
	public Empresa getEmpresaMaximoTotalPasivo() {

		List<Empresa> listaEmpresas = this.getEmpresas();
		Empresa empresaGanadora = listaEmpresas.get(0);
		for (Empresa unaEmpresa : listaEmpresas) {
			if (empresaGanadora.getTotalPasivo() < unaEmpresa.getTotalPasivo()) {
				empresaGanadora = unaEmpresa;
			}
		}

		return empresaGanadora;

	}


	private Double obtenerMargenTotal(Empresa unaEmpresa) {
		Double costTotal = (double) 0;
		List<Cuenta> listaCuentas = cuentaDAO.getCuentas();
		for (Long idCuenta : unaEmpresa.getListaIdCuentas()) {
			//busca para cada una de las cuentas, las q pertenecen a la empresa y suma sus cost
			for (Cuenta unaCuenta : listaCuentas) {
				if (unaCuenta.getId() == idCuenta) {
					costTotal = costTotal + cuentaDAO.totalCostltimosNAnios(unaCuenta, 10);
				}
			}

		}
		return unaEmpresa.getTotalPasivo() - costTotal;
	}


	private Double obtenerROETotal(Empresa unaEmpresa) {
		Double roeTotal = (double) 0;
		List<Cuenta> listaCuentas = cuentaDAO.getCuentas();
		for (Long idCuenta : unaEmpresa.getListaIdCuentas()) {
			//busca para cada una de las cuentas, las q pertenecen a la empresa y suma sus roes
			for (Cuenta unaCuenta : listaCuentas) {
				if (unaCuenta.getId() == idCuenta) {
					roeTotal = roeTotal + cuentaDAO.totalROEUltimosNAnios(unaCuenta, 10);
				}
			}

		}
		return roeTotal;
	}*/

	public void addEmpresa(Empresa empresa) {
		empresas.save(empresa);
	}

	public List<Empresa> getByUserId(long id) {
		return empresas.findByUsuarioId(id);
	}
}
