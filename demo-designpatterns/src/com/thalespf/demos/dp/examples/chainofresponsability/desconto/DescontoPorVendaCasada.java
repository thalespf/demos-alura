/**
 * 
 */
package com.thalespf.demos.dp.examples.chainofresponsability.desconto;

import com.thalespf.demos.dp.domain.Item;
import com.thalespf.demos.dp.domain.Orcamento;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class DescontoPorVendaCasada implements Desconto {

	private Desconto proximo;

	/* (non-Javadoc)
	 * @see com.thalespf.demos.dp.domain.descontos.Desconto#desconta(com.thalespf.demos.dp.domain.imposto.Orcamento)
	 */
	@Override
	public double desconta(Orcamento orcamento) {
		if(ehVendaCasada(orcamento)) {
			return orcamento.getValor() * 0.05;
		}
		return getProximo().desconta(orcamento);
	}
	
    private boolean ehVendaCasada(Orcamento orcamento) {
		return existe("Caneta", orcamento) && existe("Lapis", orcamento) ? true : false;
	}

	private boolean existe(String nomeDoItem, Orcamento orcamento) {
        for (Item item : orcamento.getItens()) {
            if(item.getNome().equals(nomeDoItem)) return true;
        }
        return false;
    }

	/* (non-Javadoc)
	 * @see com.thalespf.demos.dp.domain.descontos.Desconto#getProximo()
	 */
	@Override
	public Desconto getProximo() {
		return proximo;
	}

	/* (non-Javadoc)
	 * @see com.thalespf.demos.dp.domain.descontos.Desconto#setProximo(com.thalespf.demos.dp.domain.descontos.Desconto)
	 */
	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

}
