/**
 * 
 */
package com.thalespf.demos.dp.domain;

import java.util.ArrayList;
import java.util.List;

import com.thalespf.demos.dp.examples.state.orcamento.EmEstadoAprovacao;
import com.thalespf.demos.dp.examples.state.orcamento.EstadoDoOrcamento;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class Orcamento {
	
	private List<Item> itens = new ArrayList<Item>();
	
	protected double valor;

	private EstadoDoOrcamento estadoAtual;
	
	public Orcamento(double valor) {
		this.valor = valor;
		setEstadoAtual(new EmEstadoAprovacao());
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public boolean ehVendaCasada() {
		return false;
	}

	public void addItem(Item item) {
		itens.add(item);
	}

	public List<Item> getItens() {
		return itens;
	}

	public boolean existemItemComValor(double valor) {
		for (Item item : itens) {
			if(item.getValor() == valor) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Aplica um desconto dependendo do estado atual do orcamento
	 */
	public void aplicaDescontoExtra() {
		if(!getEstadoAtual().foiAplicado())
			getEstadoAtual().aplicaDescontoExtra(this);
	}

	public void aprova() {
		getEstadoAtual().aprova(this);
	}

	public void reprovado() {
		getEstadoAtual().reprovado(this);
	}

	public void finaliza() {
		getEstadoAtual().finaliza(this);
	}

	public EstadoDoOrcamento getEstadoAtual() {
		return estadoAtual;
	}

	public void setEstadoAtual(EstadoDoOrcamento estadoAtual) {
		this.estadoAtual = estadoAtual;
	}
	
}
