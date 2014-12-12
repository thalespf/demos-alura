package com.thalespf.demos.oo.manager;

import com.thalespf.demos.oo.domain.Divida;
import com.thalespf.demos.oo.domain.Pagamento;

public class GerenciadorDeDividas {
	
	public void efetuaPagamento(Divida divida, double valor, String cnpjPagador, String pagador) {
		Pagamento pagamento = new Pagamento();
		pagamento.setCnpjPagador(cnpjPagador);
		pagamento.setPagador(pagador);
		pagamento.setValor(valor);
		divida.registra(pagamento);
	}

}
