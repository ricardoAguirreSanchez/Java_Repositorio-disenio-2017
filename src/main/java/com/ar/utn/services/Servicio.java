package com.ar.utn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ar.utn.dto.Persona;
import com.ar.utn.imple.PersonaDAO;

@Service
public class Servicio {
	
	@Autowired
	PersonaDAO per;
	
	public Persona creaTraePersona(){
		return per.createPersona();
	}
}
