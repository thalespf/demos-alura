/**
 * 
 */
package com.thalespf.demos.oo.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 * 
 */
@SuppressWarnings("serial")
public class Pagamentos implements Iterable<Pagamento> {
	
	private double valorPago;
	
	private List<Pagamento> pagamentos = new ArrayList<Pagamento>();
	
	@Override
	public Iterator<Pagamento> iterator() {
		return pagamentos.iterator();
	}
	
	public Collection<Pagamento> pagamentosAntesDe(Calendar data) {
		ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
		for (Pagamento pagamento : pagamentos) {
			if (pagamento.getData().before(data)) {
				pagamentosFiltrados.add(pagamento);
			}
		}
		return pagamentosFiltrados;
	}

	public Collection<Pagamento> pagamentosComValorMaiorQue(double valorMinimo) {
		ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
		for (Pagamento pagamento : pagamentos) {
			if (pagamento.getValor() > valorMinimo) {
				pagamentosFiltrados.add(pagamento);
			}
		}
		return pagamentosFiltrados;
	}

	public Collection<Pagamento> pagamentosDo(String cnpjPagador) {
		ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
		for (Pagamento pagamento : pagamentos) {
			if (pagamento.getCnpjPagador().equals(cnpjPagador)) {
				pagamentosFiltrados.add(pagamento);
			}
		}
		return pagamentosFiltrados;
	}
	
	private void paga(double valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("Valor invalido");
		}
		if (valor > 100)
			valor -= 6;
		
		valorPago += valor;

	}

	protected void registra(Pagamento pagamento) {
		pagamentos.add(pagamento);
		paga(pagamento.getValor());
	}

	public double getValorPago() {
		return valorPago;
	}

}
