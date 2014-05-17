/**
 * 
 */
package com.thalespf.demos.dp.examples.strategy;

import com.thalespf.demos.dp.domain.Conta;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public interface Investimento {
	
	public double calculaLucro(Conta contaBancaria);

}
