/**
 * 
 */
package com.thalespf.demos.dp.examples.template;

import java.util.Date;
import java.util.List;

import com.thalespf.demos.dp.domain.Banco;
import com.thalespf.demos.dp.domain.Conta;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class RelatorioComplexo extends TemplateRelatorio {
	
	public RelatorioComplexo(Banco banco) {
		super(banco);
	}

	@Override
	protected String getRodape() {
		Banco banco = getBanco();
		return banco.getEmail() + "\n" + new Date(System.currentTimeMillis()).toString();
	}
	
	@Override
	protected String getCorpo(List<Conta> contas) {
		StringBuffer buf = new StringBuffer();
		for (Conta conta : contas) {
			buf.append("Titular: " + conta.getTitular() + 
					"Agencia: " + conta.getTitular() + 
					"Numero da conta: " + conta.getNumero() +
					"\nSaldo: " + conta.getSaldo() + "\n");			
		}
		return buf.toString();
	}

	@Override
	protected String getCabecalho() {
		Banco banco = getBanco();
		return banco.getNome() + "\n" + banco.getEndereco() + "\n" + banco.getTelefone();
	}

}
