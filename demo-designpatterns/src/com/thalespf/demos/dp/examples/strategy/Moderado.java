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
public class Moderado implements Investimento {

	/* (non-Javadoc)
	 * @see com.thalespf.demos.dp.domain.investimento.Investimento#calculaLucro(com.thalespf.demos.dp.domain.investimento.ContaBancaria)
	 */
	@Override
	public double calculaLucro(Conta conta) {
		double nextDouble = new Random().nextDouble();
		if (nextDouble > 0. && nextDouble < 0.5) {
			return conta.getSaldo() * 0.025;
		} else if (nextDouble >= 0.5 && nextDouble <= 1) {
			return conta.getSaldo() * 0.07;
		}
		return 0;
	}

}
