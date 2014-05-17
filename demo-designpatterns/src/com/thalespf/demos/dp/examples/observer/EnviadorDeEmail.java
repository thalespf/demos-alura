package com.thalespf.demos.dp.examples.observer;

import com.thalespf.demos.dp.domain.NotaFiscal;

public class EnviadorDeEmail implements AcaoAposGerarNota {

	private void enviaPorEmail(NotaFiscal notaFiscal) {
		System.out.println("enviando por e-mail");
	}

	@Override
	public void notaGerada(NotaFiscal notaFiscal) {
		enviaPorEmail(notaFiscal);
	}
}