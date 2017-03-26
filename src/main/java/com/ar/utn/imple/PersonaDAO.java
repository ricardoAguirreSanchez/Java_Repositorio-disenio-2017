package com.ar.utn.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ar.utn.dao.IPersona;
import com.ar.utn.dto.Persona;

@Component
public class PersonaDAO implements IPersona {

	@Autowired
	Persona persona;
	
	@Override
	public Persona createPersona() {
		persona.setApellido("Aguirre");
		persona.setNombre("Ricardo");
		return persona;
	}

}
