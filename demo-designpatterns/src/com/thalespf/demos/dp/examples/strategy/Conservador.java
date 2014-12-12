/**
 * 
 */
package com.thalespf.demos.dp.examples.strategy;

import com.thalespf.demos.dp.domain.Conta;


/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 * 
 */
public class Conservador implements Investimento {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.thalespf.demos.dp.domain.investimento.Investimento#calculaLucro(com
	 * .thalespf.demos.dp.domain.investimento.Investimento)
	 */
	@Override
	public double calculaLucro(Conta conta) {
		return conta.getSaldo() * 0.08;
	}

}
