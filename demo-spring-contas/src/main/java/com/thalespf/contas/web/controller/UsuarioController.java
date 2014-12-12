/**
 * 
 */
package com.thalespf.contas.web.controller;

import javax.servlet.http.HttpSession;

import javassist.compiler.MemberResolver.Method;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thalespf.contas.dao.UsuarioDAO;
import com.thalespf.contas.modelo.Usuario;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
@Controller
@RequestMapping(value="/usuario")
public class UsuarioController {
	
	@RequestMapping(value="/loginForm", method=RequestMethod.GET)
	public String loginForm() {
		
		
		return "usuario/login";
	}
	
	@RequestMapping(value="/efetuaLogin", method=RequestMethod.POST)
	public String logaUsuario(Usuario usuario, HttpSession session) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if(usuarioDAO.existeUsuario(usuario)) {
			session.setAttribute("usuarioLogado", usuario);
			return "menu";
		}
		
		return "redirect:/usuario/";
	}

}
