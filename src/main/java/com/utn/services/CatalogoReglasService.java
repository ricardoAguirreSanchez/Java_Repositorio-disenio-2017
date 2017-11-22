package com.utn.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CatalogoReglasService {
	//devuelte todas las reglas que hay en el sistema (json)
	List<String> getReglas();
	
}
