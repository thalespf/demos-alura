package com.thalespf.demos.oo.domain;

public class Cpf implements Documento {

	private String cpf;

	@Override
	public boolean ehValido() {
		return true;
	}

	@Override
	public String getValor() {
		return cpf;
	}

}
