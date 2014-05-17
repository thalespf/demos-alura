/**
 * 
 */
package com.thalespf.demos.dp.examples.template;

import java.util.List;

import com.thalespf.demos.dp.domain.Banco;
import com.thalespf.demos.dp.domain.Conta;


/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public abstract class TemplateRelatorio implements Relatorio {
	
	private Banco banco;

	public TemplateRelatorio(Banco banco) {
		this.banco = banco;
	}
	
	@Override
	public void exibe(List<Conta> contas) {
		System.out.println(getCabecalho() + "\n\n" + getCorpo(contas) + "\n\n" + getRodape());
	}
	
	protected Banco getBanco() {
		return banco;
	}

	protected abstract String getRodape();

	protected abstract String getCorpo(List<Conta> contas);

	protected abstract String getCabecalho();

}
