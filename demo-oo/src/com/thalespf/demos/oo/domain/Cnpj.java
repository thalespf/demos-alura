package com.thalespf.demos.oo.domain;


public class Cnpj implements Documento {
	
	public String cnpjCredor;

	public Cnpj(String cnpjCredor) {
		this.cnpjCredor = cnpjCredor;
	}
	
	@Override
	public boolean ehValido() {
		return true;
	}
	
	@Override
	public String getValor() {
		return cnpjCredor;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		
		if(obj.getClass() != this.getClass())
			return false;
		
		return cnpjCredor.equals(((Cnpj)obj).getCnpj());
	}
	
	@Override
	public int hashCode() {
		return cnpjCredor.hashCode();
	}
	
	public boolean cnpjValido() {
		return primeiroDigitoVerificadorDoCnpj() == primeiroDigitoCorretoParaCnpj()
				&& segundoDigitoVerificadorDoCnpj() == segundoDigitoCorretoParaCnpj();
	}

	private int segundoDigitoCorretoParaCnpj() {
		return 0;
		// Calcula o primeiro dígito verificador correto para
		// o CNPJ armazenado no atributo cnpj
	}

	private int segundoDigitoVerificadorDoCnpj() {
		return 0;
		// Calcula o primeiro dígito verificador correto para
		// o CNPJ armazenado no atributo cnpj
	}

	private int primeiroDigitoCorretoParaCnpj() {
		return 0;
		// Extrai o primeiro dígito verificador do CNPJ armazenado
		// no atributo cnpj
	}

	private int primeiroDigitoVerificadorDoCnpj() {
		return 0;
		// Extrai o segundo dígito verificador do CNPJ armazenado
		// no atributo cnpj
	}

	public String getCnpj() {
		return cnpjCredor;
	}

	public void setCnpj(String cnpjCredor) {
		this.cnpjCredor = cnpjCredor;
	}
	
}