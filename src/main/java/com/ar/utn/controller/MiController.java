package com.ar.utn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ar.utn.dto.Persona;
import com.ar.utn.services.Servicio;


@Controller
public class MiController {
	
	@Autowired
	Servicio servicio;
	@Autowired
	Persona persona;
	
	@RequestMapping("irHola")
	public ModelAndView redireccionar()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hola");
		return mv;
		  
	}
	
	@RequestMapping("irMostrar")
	public String agregar (ModelMap model)
	{
		persona = servicio.creaTraePersona();
		model.addAttribute("nombreModel", persona.getNombre());
		model.addAttribute("apellidoModel", persona.getApellido());
		return "exito";
	}

}
