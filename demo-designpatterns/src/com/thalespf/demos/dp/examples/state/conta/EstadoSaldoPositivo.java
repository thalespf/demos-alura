package com.thalespf.demos.dp.examples.state.conta;

import com.thalespf.demos.dp.domain.Conta;


/**
 * 
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class EstadoSaldoPositivo implements EstadoDaConta {

	@Override
	public void deposita(Conta conta, double valor) {
		conta.depositaValor(conta.getValor() + valor * 0.98);
	}

	@Override
	public double saque(Conta conta, double valor) {
		double sacado = conta.depositaValor(conta.getValor() - valor);
		if(conta.getValor() < 0) conta.setEstadoAtual(new EstadoSaldoNegativo());
		return sacado;
	}

}
