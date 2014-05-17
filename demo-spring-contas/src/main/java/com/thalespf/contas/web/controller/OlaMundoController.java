/**
 * 
 */
package com.thalespf.contas.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
@Controller
public class OlaMundoController {
	
	@RequestMapping(value="/olaMundoSpring")
	public String execute() {
		return "ok";
	}

}
