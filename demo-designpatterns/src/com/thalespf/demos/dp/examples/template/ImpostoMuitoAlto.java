package com.thalespf.demos.dp.examples.template;

import com.thalespf.demos.dp.domain.Imposto;
import com.thalespf.demos.dp.domain.Orcamento;

public class ImpostoMuitoAlto extends Imposto {

	public ImpostoMuitoAlto(Imposto imposto) {
		super(imposto);
	}

	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.2 + calculaImpostoComposto(orcamento);
	}

}
