/**
 * 
 */
package com.thalespf.demos.dp.examples.state.orcamento;

import com.thalespf.demos.dp.domain.Orcamento;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public interface EstadoDoOrcamento extends MudaEstado {

	public void aplicaDescontoExtra(Orcamento orcamento);
	
	public boolean foiAplicado();

}
