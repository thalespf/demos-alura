package com.thalespf.demos.dp.examples.strategy;

import com.thalespf.demos.dp.domain.Conta;
import com.thalespf.demos.dp.domain.ICCC;
import com.thalespf.demos.dp.domain.Imposto;
import com.thalespf.demos.dp.domain.Orcamento;

class Teste {
	public static void main(String[] args) {
		Orcamento reforma = new Orcamento(500.0);

		Imposto novoImposto = new ICCC();
		System.out.println(novoImposto.calcula(reforma));
		
		Conta conta = new Conta(2000., "Antonio", "156687");
		System.out.println("Saldo da conta: " + conta.getSaldo());
		RealizadorDeInvestimento ri = new RealizadorDeInvestimento();
		ri.investir(conta, new Conservador());
		
		System.out.println("Novo saldo: " + conta.getSaldo());
	}
}