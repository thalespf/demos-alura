/**
 * 
 */
package com.thalespf.demos.dp.examples.chainofresponsability.desconto;

import com.thalespf.demos.dp.domain.Orcamento;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class DescontoParaUmValor implements Desconto {

	private Desconto proximo;

	@Override
	public double desconta(Orcamento orcamento) {
		if(orcamento.getValor() > 500.) {
			return orcamento.getValor() * 0.07;
		}
		Desconto proximo = getProximo();
		if(proximo == null)
			return 0;
		return proximo.desconta(orcamento);
	}

	@Override
	public Desconto getProximo() {
		return proximo;
	}

	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

}
