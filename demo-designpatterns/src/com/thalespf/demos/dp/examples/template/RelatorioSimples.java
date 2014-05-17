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
public class RelatorioSimples extends TemplateRelatorio {
	
	public RelatorioSimples(Banco banco) {
		super(banco);
	}

	@Override
	protected String getRodape() {
		Banco banco = getBanco();
		return banco.getNome() + banco.getTelefone();
	}
	
	@Override
	protected String getCorpo(List<Conta> contas) {
		StringBuffer buf = new StringBuffer();
		for (Conta conta : contas) {
			buf.append("Titular: " + conta.getTitular() + "\nSaldo: " + conta.getSaldo() + "\n");			
		}
		return buf.toString();
	}

	@Override
	protected String getCabecalho() {
		Banco banco = getBanco();
		return banco.getNome() + banco.getTelefone();
	}

}
