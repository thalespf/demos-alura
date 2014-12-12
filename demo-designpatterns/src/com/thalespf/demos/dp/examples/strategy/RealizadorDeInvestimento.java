/**
 * 
 */
package com.thalespf.demos.dp.examples.strategy;

import com.thalespf.demos.dp.domain.Conta;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class RealizadorDeInvestimento {
	
	public void investir(Conta contaBancaria, Investimento investimento) {
		double lucro = investimento.calculaLucro(contaBancaria);
		
		double saldo = contaBancaria.getSaldo() + 0.75 * lucro;
		contaBancaria.deposita(saldo);
	}

}
