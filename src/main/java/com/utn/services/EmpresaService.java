package com.utn.services;

import com.utn.model.Empresa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpresaService {
	
	List<Empresa> getEmpresas();

}
