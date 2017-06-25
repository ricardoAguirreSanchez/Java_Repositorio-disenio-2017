package com.utn.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utn.model.Cuenta;

@Service
public interface CatalogoReglasService {
	//devuelte todas las reglas que hay en el sistema (json)
	List<String> getReglas();
	
}
