/**
 * 
 */
package com.thalespf.demos.dp.examples.template;

import com.thalespf.demos.dp.domain.Imposto;
import com.thalespf.demos.dp.domain.Orcamento;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public abstract class TemplateDeImpostoCondicional extends Imposto {
	
	public TemplateDeImpostoCondicional() {
		super();
	}

	public TemplateDeImpostoCondicional(Imposto imposto) {
		super(imposto);
	}

	@Override
	public double calcula(Orcamento orcamento) {
		if(deveraConcederImpostoMaximo(orcamento)) {
			return concedeImpostoMaximo(orcamento);
		} else {
			return concedeImpostoMinimo(orcamento);
		}
	}

	public abstract double concedeImpostoMinimo(Orcamento orcamento);

	public abstract double concedeImpostoMaximo(Orcamento orcamento);

	public abstract boolean deveraConcederImpostoMaximo(Orcamento orcamento);

}
