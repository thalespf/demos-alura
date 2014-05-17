package com.thalespf.demos.dp.examples.observer;

import com.thalespf.demos.dp.domain.NotaFiscal;

public class NotaFiscalDao implements AcaoAposGerarNota {
	
	private void salvaNoBanco(NotaFiscal notaFiscal) {
		System.out.println("salvando no banco");
	}

	@Override
	public void notaGerada(NotaFiscal notaFiscal) {
		salvaNoBanco(notaFiscal);
	}
	
}