package com.thalespf.demos.dp.examples.observer;

import com.thalespf.demos.dp.domain.NotaFiscal;

class Multiplicador implements AcaoAposGerarNota {
	private double fator;

	public Multiplicador(double fator) {
		this.fator = fator;
	}

	@Override
	public void notaGerada(NotaFiscal notaFiscal) {
		notaFiscal.setValorBruto(notaFiscal.getValorBruto() * fator);
	}
}