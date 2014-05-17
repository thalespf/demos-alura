package com.thalespf.demos.dp.examples.observer;

import com.thalespf.demos.dp.domain.NotaFiscal;

public class EnviadorDeSms implements AcaoAposGerarNota {
	
	private void enviaPorSms(NotaFiscal notaFiscal) {
		System.out.println("enviando por sms");
	}

	@Override
	public void notaGerada(NotaFiscal notaFiscal) {
		enviaPorSms(notaFiscal);
	}
}