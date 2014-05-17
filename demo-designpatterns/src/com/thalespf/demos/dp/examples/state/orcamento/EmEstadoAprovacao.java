/**
 * 
 */
package com.thalespf.demos.dp.examples.state.orcamento;

import com.thalespf.demos.dp.domain.Orcamento;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class EmEstadoAprovacao implements EstadoDoOrcamento {

	private boolean aplicado;

	/* (non-Javadoc)
	 * @see com.thalespf.demos.dp.examples.imposto.EstadoDoOrcamento#aplicaDescontoExtra(com.thalespf.demos.dp.examples.imposto.Orcamento)
	 */
	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		orcamento.setValor(orcamento.getValor() - (orcamento.getValor() * 0.05));
		aplicado = true;
	}
	
	@Override
	public boolean foiAplicado() {
		return aplicado;
	}

	@Override
	public void aprova(Orcamento orcamento) {
		orcamento.setEstadoAtual(new EstadoAprovado());
	}

	@Override
	public void reprovado(Orcamento orcamento) {
		orcamento.setEstadoAtual(new EstadoReprovado());
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		throw new RuntimeException("Orcamento nao pode ser finalizado.");
	}

}
