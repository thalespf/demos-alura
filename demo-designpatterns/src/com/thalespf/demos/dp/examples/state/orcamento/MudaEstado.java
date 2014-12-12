/**
 * 
 */
package com.thalespf.demos.dp.examples.state.orcamento;

import com.thalespf.demos.dp.domain.Orcamento;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public interface MudaEstado {
	
	public void aprova(Orcamento orcamento);
	
	public void reprovado(Orcamento orcamento);
	
	public void finaliza(Orcamento orcamento);

}
