/**
 * 
 */
package com.thalespf.demos.dp.domain;

import java.util.Calendar;

import com.thalespf.demos.dp.examples.state.conta.EstadoDaConta;
import com.thalespf.demos.dp.examples.state.conta.EstadoSaldoPositivo;
import com.thalespf.demos.dp.examples.state.conta.Operacoes;


/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class Conta implements Operacoes {
	
	private double salso;
	private String titular;
	private String numero;
	private Calendar dataAbertura;
	private double valor;
	
	private EstadoDaConta estadoAtual = new EstadoSaldoPositivo();
	
	private Conta() {
		
	}
	
	public Conta(double salso, String titular, String numero) {
		super();
		this.salso = salso;
		this.titular = titular;
		this.numero = numero;
	}
	
	@Override
	public void deposita(double valor) {
		getEstadoAtual().deposita(this, valor);
	}
	
	@Override
	public double saque(double valor) {
		return getEstadoAtual().saque(this, valor);
	}

	public double getSaldo() {
		return salso;
	}

	public String getTitular() {
		return titular;
	}

	public String getNumero() {
		return numero;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public double getValor() {
		return valor;
	}

	public double depositaValor(double valor) {
		this.valor = valor;
		return valor;
	}

	public EstadoDaConta getEstadoAtual() {
		return estadoAtual;
	}

	public void setEstadoAtual(EstadoDaConta estadoAtual) {
		this.estadoAtual = estadoAtual;
	}
	
}
