/**
 * 
 */
package com.thalespf.agenda.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
@SuppressWarnings("serial")
public class OiMundo extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		
		// escreve o texto
		writer.println("<html>");
		writer.println("<body>");
		writer.println("Primeira servlet");
		writer.println("</body>");
		writer.println("</html>");
	}


}
