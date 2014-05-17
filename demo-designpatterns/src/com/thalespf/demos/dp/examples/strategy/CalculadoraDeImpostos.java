/**
 * 
 */
package com.thalespf.demos.dp.examples.strategy;

import com.thalespf.demos.dp.domain.Imposto;
import com.thalespf.demos.dp.domain.Orcamento;


/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class CalculadoraDeImpostos {
	
	public double calculaImposto(Orcamento orcamento, Imposto imposto) {
		double calculo = imposto.calcula(orcamento);
		System.out.println(calculo);
		return calculo;
	}

}
