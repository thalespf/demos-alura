/**
 * 
 */
package com.thalespf.demos.dp.examples.strategy;

import java.util.Random;

import com.thalespf.demos.dp.domain.Conta;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 * 
 */
public class Arrojado implements Investimento {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.thalespf.demos.dp.domain.investimento.Investimento#calculaLucro(com
	 * .thalespf.demos.dp.domain.investimento.Investimento)
	 */
	@Override
	public double calculaLucro(Conta conta) {
		double nextDouble = new Random().nextDouble();
		if (nextDouble < 0.30) {
			return conta.getSaldo() * 0.05;
		} else if (nextDouble >= 0.3 && nextDouble < 0.5) {
			return conta.getSaldo() * 0.03;
		} else if (nextDouble >= 0.5) {
			return conta.getSaldo() * 0.006;
		}
		return 0;
	}

}
