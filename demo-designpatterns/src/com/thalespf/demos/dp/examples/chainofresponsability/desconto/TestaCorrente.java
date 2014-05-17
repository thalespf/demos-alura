/**
 * 
 */
package com.thalespf.demos.dp.examples.chainofresponsability.desconto;

import com.thalespf.demos.dp.domain.Item;
import com.thalespf.demos.dp.domain.Orcamento;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class TestaCorrente {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Desconto d1 = new DescontoPorCincoItens();
		Desconto d2 = new DescontoParaUmValor();
		Desconto d3 = new DescontoPorVendaCasada();
		
		d1.setProximo(d2);
		d2.setProximo(d3);
		
		Orcamento orcamento = new Orcamento(400.);
		orcamento.addItem(new Item("Caneta"));
		orcamento.addItem(new Item("Lapis"));
		orcamento.addItem(new Item("Estojo"));
		double desconto = d1.desconta(orcamento);
		
		System.out.println("Desconto foi de: " + desconto);
	}

}
