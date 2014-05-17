/**
 * 
 */
package com.thalespf.demos.dp.examples.state.orcamento;

import com.thalespf.demos.dp.domain.Orcamento;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class TesteDescontoExtra {
	
	public static void main(String[] args) {
		
		Orcamento materiais = new Orcamento(1000.);
		
		System.out.println(materiais.getValor());
		
		materiais.aplicaDescontoExtra();
		
		System.out.println(materiais.getValor());
		
		materiais.aprova();
		
		materiais.aplicaDescontoExtra();
		
		System.out.println(materiais.getValor());
	}

}
