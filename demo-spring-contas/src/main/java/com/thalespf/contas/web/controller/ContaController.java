/**
 * 
 */
package com.thalespf.contas.web.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thalespf.contas.dao.ContaDAO;
import com.thalespf.contas.modelo.Conta;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 * 
 */
@Controller()
public class ContaController {
	
	private ContaDAO contaDAO;
	
	@Inject
	public ContaController(ContaDAO contaDAO) {
		super();
		this.contaDAO = contaDAO;
	}

	@RequestMapping(value = "/form")
	public String formulario() {
		return "conta/formulario";
	}
	
	@RequestMapping("/pagaConta")
	public void pagaConta(Conta conta, HttpServletResponse response) {
		
		response.setStatus(HttpStatus.OK.ordinal());
	}

	@RequestMapping(value = "/adicionaConta")
	public String adicionaConta(@Valid Conta conta, BindingResult result) {
		System.out.println("Conta adicionada e: " + conta.getDescricao()
				+ " com tipo " + conta.getTipo());
		
		if(result.hasErrors()) {
			return "conta/formulario";
		}

		contaDAO.adiciona(conta);

		return "conta/conta-adicionada";
	}

	@RequestMapping("/alteraConta")
	public String altera(Conta conta) {
		return "redirect:listaContas";
	}

	@RequestMapping("/mostraConta")
	public String mostraConta(Long id, Model model) {
		Conta conta = contaDAO.buscaPorId(id);
		model.addAttribute("conta", conta);

		return "conta/mostra";
	}

	@RequestMapping("removeConta")
	public String remove(Conta conta) {
		contaDAO.remove(conta);
		System.out.println("Conta deletada");
		return "redirect:listaContas";
	}

	@RequestMapping("/listaContas")
	public String lista(Model mv) {
		List<Conta> contas = contaDAO.lista();

		mv.addAttribute("contas", contas);
		return "conta/lista";
	}

}
