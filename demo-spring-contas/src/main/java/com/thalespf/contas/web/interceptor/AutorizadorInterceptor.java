/**
 * 
 */
package com.thalespf.contas.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		String uri = request.getRequestURI();
		
		if(uri.endsWith("usuario/loginForm") || uri.endsWith("efetuaLogin") || 
				uri.contains("resources")) {
			return true;
		}
		
		if(request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		}
		
		response.sendRedirect("/contas/usuario/loginForm");
		
		return false;
		
	}

}
