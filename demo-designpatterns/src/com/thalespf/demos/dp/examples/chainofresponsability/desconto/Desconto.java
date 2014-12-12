/**
 * 
 */
package com.thalespf.demos.dp.examples.chainofresponsability.desconto;

import com.thalespf.demos.dp.domain.Orcamento;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public interface Desconto {
	
	public double desconta(Orcamento orcamento);

	public Desconto getProximo();

	public void setProximo(Desconto proximo);

}
