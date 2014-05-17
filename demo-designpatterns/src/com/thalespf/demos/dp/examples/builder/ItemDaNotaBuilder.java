/**
 * 
 */
package com.thalespf.demos.dp.examples.builder;

import com.thalespf.demos.dp.domain.ItemDaNota;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class ItemDaNotaBuilder {

	private double valor;
	private String nome;

	public ItemDaNotaBuilder comValor(double valor) {
		this.valor = valor;
		return this;
	}

	public ItemDaNotaBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}

	public ItemDaNota create() {
		return new ItemDaNota(valor, nome);
	}

}
