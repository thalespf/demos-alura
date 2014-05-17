/**
 * 
 */
package com.thalespf.demos.dp.examples.state.orcamento;

import com.thalespf.demos.dp.domain.Orcamento;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class EstadoFinalizado implements EstadoDoOrcamento {

	private boolean aplicado;

	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		aplicado = true;
	}

	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Orcamento nao pode ser aprovado.");
	}

	@Override
	public void reprovado(Orcamento orcamento) {
		throw new RuntimeException("Orcamento nao pode ser reprovado.");
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		throw new RuntimeException("Orcamento nao pode ser finalizado.");
	}
	
	@Override
	public boolean foiAplicado() {
		return aplicado;
	}

}
