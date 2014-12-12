/**
 * 
 */
package com.thalespf.demos.dp.domain;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public abstract class Imposto {
	
	private Imposto imposto;
	
	public Imposto(Imposto imposto) {
		super();
		this.imposto = imposto;
	}

	public Imposto() {
	}
	
	public abstract double calcula(Orcamento orcamento);
	
	protected double calculaImpostoComposto(Orcamento orcamento) {
		if(imposto == null)
			return 0;
		return imposto.calcula(orcamento);
	}

}
