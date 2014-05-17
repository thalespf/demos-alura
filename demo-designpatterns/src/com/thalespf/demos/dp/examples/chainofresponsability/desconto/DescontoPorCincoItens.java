/**
 * 
 */
package com.thalespf.demos.dp.examples.chainofresponsability.desconto;

import com.thalespf.demos.dp.domain.Orcamento;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class DescontoPorCincoItens implements Desconto {

	private Desconto proximo;
	
	public DescontoPorCincoItens() {
	}

	/* (non-Javadoc)
	 * @see com.thalespf.demos.dp.domain.descontos.Desconto#desconta(com.thalespf.demos.dp.domain.imposto.Orcamento)
	 */
	@Override
	public double desconta(Orcamento orcamento) {
		if(orcamento.getItens().size() > 5) {
			return orcamento.getValor() * 0.1;
		}
		return getProximo().desconta(orcamento);
	}
	
	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

	@Override
	public Desconto getProximo() {
		return proximo;
	}

}
