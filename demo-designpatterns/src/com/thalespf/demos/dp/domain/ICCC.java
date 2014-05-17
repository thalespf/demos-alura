/**
 * 
 */
package com.thalespf.demos.dp.domain;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class ICCC extends Imposto {
	
	/* (non-Javadoc)
	 * @see com.thalespf.demos.dp.domain.Imposto#calcula(com.thalespf.demos.dp.domain.Orcamento)
	 */
	@Override
	public double calcula(Orcamento orcamento) {
		if(orcamento.getValor() >=0 && orcamento.getValor() < 1000.) {
			return orcamento.getValor() * 0.05;
		} else if(orcamento.getValor() >= 1000. && orcamento.getValor() >= 3000.) {
			return orcamento.getValor() * 0.07;
		} else if(orcamento.getValor() >= 3000.) {
			return orcamento.getValor() * 0.08 + 30;
		}
		return 0;
	}

}
