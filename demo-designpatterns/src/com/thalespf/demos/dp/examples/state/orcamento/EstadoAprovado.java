/**
 * 
 */
package com.thalespf.demos.dp.examples.state.orcamento;

import com.thalespf.demos.dp.domain.Orcamento;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class EstadoAprovado implements EstadoDoOrcamento {

	private boolean aplicado;

	@Override
	public boolean foiAplicado() {
		return aplicado;
	}
	
	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		orcamento.setValor(orcamento.getValor() - (orcamento.getValor() * 0.02));
		aplicado = true;
	}

	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Orcamento ja esta aprovado");
	}

	@Override
	public void reprovado(Orcamento orcamento) {
		throw new RuntimeException("Orcamento nao pode ser reprovado.");
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		orcamento.setEstadoAtual(new EstadoFinalizado());
	}

}
