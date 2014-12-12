/**
 * 
 */
package com.thalespf.demos.dp.examples.chainofresponsability.desconto;

import com.thalespf.demos.dp.domain.Orcamento;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CalculadoraDeDesconto calculadoraDeDesconto = new CalculadoraDeDesconto();
		Orcamento orcamento = new Orcamento(500.);
		double desconto = calculadoraDeDesconto.calcula(orcamento);
		
		System.out.println("Desconto foi de: " + desconto);
	}

}
