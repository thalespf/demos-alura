/**
 * 
 */
package com.thalespf.demos.oo.manager;

import java.text.NumberFormat;
import java.util.Locale;

import com.thalespf.demos.oo.domain.Cnpj;
import com.thalespf.demos.oo.domain.Divida;
import com.thalespf.demos.oo.domain.Pagamento;
import com.thalespf.demos.oo.domain.Pagamentos;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 * 
 */
public class RelatorioDeDivida {

	private Divida divida;

	public RelatorioDeDivida(Divida divida) {
		this.divida = divida;
	}

	public void gerar() {
		System.out.println("Credor: " + divida.getCredor());
		System.out.println("Cnpj credor: " + divida.getDocumentoCredor().getValor());

		NumberFormat formatadorDeNumero = NumberFormat
				.getCurrencyInstance(new Locale("pt", "BR"));

		// agora utilizamos uma instância da classe NumberFormat para fazer a
		// exibição dos valores
		System.out.println("Valor a pagar: "
				+ formatadorDeNumero.format(divida.getValorAPagar()));
		System.out.println("Valor total: "
				+ formatadorDeNumero.format(divida.getTotal()));
	}
	
	public static void main(String[] args) {
		Divida divida = new Divida();
		divida.setCredor("Credor");
		divida.setDocumentoCredor(new Cnpj("000.000.000/0000-1"));
		divida.setTotal(100);
		
		Pagamento pagamento1 = new Pagamento();
		pagamento1.setCnpjPagador("000.000.002/0000-2");
		pagamento1.setPagador("Empresa X");
		pagamento1.setValor(10);
		
		divida.registra(pagamento1);
		
		RelatorioDeDivida relatorioDeDivida =  new RelatorioDeDivida(divida);
		relatorioDeDivida.gerar();
		
	}

}
