/**
 * 
 */
package com.thalespf.demos.dp.domain;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class Item {

	private String nome;
	private double valor;

	public Item(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}

}
