/**
 * 
 */
package com.thalespf.demos.dp.examples.chainofresponsability.desconto;

import com.thalespf.demos.dp.domain.Orcamento;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class SemDesconto implements Desconto {

	@Override
	public double desconta(Orcamento orcamento) {
		return 0;
	}

	@Override
	public Desconto getProximo() {
		return null;
	}

	@Override
	public void setProximo(Desconto proximo) {
		
	}

}
