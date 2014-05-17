/**
 * 
 */
package com.thalespf.demos.dp.domain;

import java.util.List;

import com.thalespf.demos.dp.examples.template.TemplateDeImpostoCondicional;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class IHIT extends TemplateDeImpostoCondicional {

	/* (non-Javadoc)
	 * @see com.thalespf.demos.dp.domain.imposto.TemplateDeImpostoCondicional#concedeImpostoMinimo(com.thalespf.demos.dp.domain.imposto.Orcamento)
	 */
	@Override
	public double concedeImpostoMinimo(Orcamento orcamento) {
		return orcamento.getValor() * 0.01 + orcamento.getItens().size();
	}

	/* (non-Javadoc)
	 * @see com.thalespf.demos.dp.domain.imposto.TemplateDeImpostoCondicional#concedeImpostoMaximo(com.thalespf.demos.dp.domain.imposto.Orcamento)
	 */
	@Override
	public double concedeImpostoMaximo(Orcamento orcamento) {
		return orcamento.getValor() * 0.13 + 100.;
	}

	/* (non-Javadoc)
	 * @see com.thalespf.demos.dp.domain.imposto.TemplateDeImpostoCondicional#deveraConcederImpostoMaximo(com.thalespf.demos.dp.domain.imposto.Orcamento)
	 */
	@Override
	public boolean deveraConcederImpostoMaximo(Orcamento orcamento) {
		if(existeDoisItensComMesmoNome(orcamento)) {
			return true;
		}
		return false;
	}

	private boolean existeDoisItensComMesmoNome(Orcamento orcamento) {
		List<Item> itens = orcamento.getItens();
		Item item1 = itens.get(0);
		for (Item item : itens) {
			if(item.getNome().equals(item1.getNome()))
				return true;
		}
		return false;
	}

}
