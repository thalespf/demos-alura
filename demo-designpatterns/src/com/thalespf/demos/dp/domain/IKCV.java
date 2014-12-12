/**
 * 
 */
package com.thalespf.demos.dp.domain;

import com.thalespf.demos.dp.examples.template.TemplateDeImpostoCondicional;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class IKCV extends TemplateDeImpostoCondicional {
	
	public IKCV() {
	}
	
	public IKCV(Imposto imposto) {
		super(imposto);
	}

	@Override
	public double concedeImpostoMinimo(Orcamento orcamento) {
		return orcamento.getValor() * 0.06 + calculaImpostoComposto(orcamento);
	}

	@Override
	public double concedeImpostoMaximo(Orcamento orcamento) {
		return orcamento.getValor() * 0.1 + calculaImpostoComposto(orcamento);
	}

	@Override
	public boolean deveraConcederImpostoMaximo(Orcamento orcamento) {
		if(orcamento.getValor() > 500. && orcamento.existemItemComValor(100)) {
			return true;
		}
		return false;
	}

}
