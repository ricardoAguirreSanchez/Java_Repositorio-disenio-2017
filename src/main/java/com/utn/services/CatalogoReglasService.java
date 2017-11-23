package com.utn.services;

import com.utn.model.Regla;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CatalogoReglasService {
	//devuelte todas las reglas que hay en el sistema (json)
	List<Regla> getReglas();
	
}
