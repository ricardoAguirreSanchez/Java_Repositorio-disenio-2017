package com.ar.utn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MiController {
	
	@RequestMapping("irHola")
	public ModelAndView redireccionar()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hola");
		return mv;
		  
	}

}
