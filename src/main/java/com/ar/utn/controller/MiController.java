package com.ar.utn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ar.utn.dto.Persona;

@Controller
public class MiController {
	
	@RequestMapping("irHola")
	public ModelAndView redireccionar()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hola");
		return mv;
		  
	}
	
	@RequestMapping("irFormulario")
	public ModelAndView enviarARegistrar()
	{
		return new ModelAndView("formulario","command",new Persona());
	  
	}
	
	@RequestMapping("mandar")
	public String agregar (Persona p,ModelMap model)
	{
		model.addAttribute("nombreModel", p.getNombre());
		model.addAttribute("apellidoModel", p.getApellido());
		return "exito";
	}
}
