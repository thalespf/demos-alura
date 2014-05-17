/**
 * 
 */
package com.thalespf.demos.dp.domain;

import com.thalespf.demos.dp.examples.template.TemplateDeImpostoCondicional;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class ICPP extends TemplateDeImpostoCondicional {

	@Override
	public double concedeImpostoMinimo(Orcamento orcamento) {
		return orcamento.getValor() * 0.05;
	}

	@Override
	public double concedeImpostoMaximo(Orcamento orcamento) {
		return orcamento.getValor() * 0.07;
	}

	@Override
	public boolean deveraConcederImpostoMaximo(Orcamento orcamento) {
		if(orcamento.getValor() < 500.) {
			return false;
		}
		return true;
	}

}
