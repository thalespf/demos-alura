package com.thalespf.demos.dp.examples.observer;

import com.thalespf.demos.dp.domain.NotaFiscal;

public class Impressora implements AcaoAposGerarNota {
	
	private void imprime(NotaFiscal notaFiscal) {
		System.out.println("imprimindo notaFiscal");
	}

	@Override
	public void notaGerada(NotaFiscal notaFiscal) {
		imprime(notaFiscal);
	}
}