package com.utn.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utn.model.Empresa;

@Service
public interface EmpresaService {
	
	List<Empresa> getEmpresas();

}
