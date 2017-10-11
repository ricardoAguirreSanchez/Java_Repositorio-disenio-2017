package com.utn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.utn.repositorio.Repositorio;
import com.utn.repositorio.Usuarios;

@Controller
public class LogInController {

	 @RequestMapping(value="/logIn",method = RequestMethod.POST)
	    public String homepage(HttpServletRequest request, HttpServletResponse response, @RequestParam String username, @RequestParam String password) throws IOException, ServletException{
	    	Repositorio	repo = new Repositorio("DDS_TEST");
	    	Usuarios usuarios = new Usuarios(repo.getEntityManager());
	    	response.setContentType("text/html");
	    	String redireccion="/";
	    	HttpSession sesion = request.getSession();
	    	String usuario, contrasena;
	    	usuario=username;
	    	contrasena=password;
	    	//TODO aca se buscaria el usuario en la tabla USUARIO de la base de datos
	    	if((usuarios.buscarPorUserAndPassword(usuario, contrasena) != null) && sesion.getAttribute("usuario")==null){
	    		sesion.setAttribute("usuario", usuario);
	    		redireccion="redirect:/index";
	    	}
	        return redireccion;
	    }
	    
	    @RequestMapping(value="/index",method = RequestMethod.GET)
	    public String home(HttpServletRequest request, HttpServletResponse response){
	    	HttpSession sesion = request.getSession();
	    	if(sesion.getAttribute("usuario")!=null)
	    		return "login2.html";
	    	try {
				response.sendRedirect("/");
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	return "/";
	    }
		@RequestMapping(value="/logOut", method = RequestMethod.GET)
	    public String logOut(HttpServletRequest request, HttpServletResponse response){
	    	HttpSession session=request.getSession();
	    	session.setAttribute("usuario",	null);
	    	session.invalidate();
	    	return "/";
	    }
    
//    @RequestMapping(value="/validarLogeado", method = RequestMethod.GET)
//    public Boolean validar(HttpServletRequest request){
//    	Boolean valido=true;
//    	HttpSession session=request.getSession();
//    	if(session.getAttribute("usuario") == null){
//    		valido=false;
//    	}
//    	return valido;
//    }
}