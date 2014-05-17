package com.thalespf.demos.dp.examples.state.conta;

import com.thalespf.demos.dp.domain.Conta;



/**
 * 
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class EstadoSaldoNegativo implements EstadoDaConta {

	@Override
	public void deposita(Conta conta, double valor) {
		conta.depositaValor(conta.getValor() + valor * 0.95);
		if(conta.getValor() > 0) conta.setEstadoAtual(new EstadoSaldoPositivo());
	}

	@Override
	public double saque(Conta conta, double valor) {
		throw new RuntimeException("Voce nao pode saquer de uma conta negativaS");
	}

}
