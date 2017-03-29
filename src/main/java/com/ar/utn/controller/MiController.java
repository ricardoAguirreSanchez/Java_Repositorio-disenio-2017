package com.ar.utn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ar.utn.imple.ServicioImple;
import com.ar.utn.services.Servicio;


@Controller
public class MiController {
	
	@Autowired
	ServicioImple servicio;
	
	// Este metodo redirecciona, para q se muestre la vista consulta.jsp
	@RequestMapping("iniciarTP")
	public ModelAndView redireccionar()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("consulta");
		return mv;
	}
	
	// Este metodo responde la peticion de consular por filtro
	
	
	
	// Este metodo responde a la peticion de consultar totales
	
	
}
