/**
 * 
 */
package com.thalespf.demos.dp.domain;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class ICMS extends Imposto {

	public ICMS(ICPP icpp) {
		super(icpp);
	}

	/* (non-Javadoc)
	 * @see com.thalespf.demos.dp.Imposto#calcula(com.thalespf.demos.dp.Orcamento)
	 */
	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.1 + calculaImpostoComposto(orcamento);
	}

}
