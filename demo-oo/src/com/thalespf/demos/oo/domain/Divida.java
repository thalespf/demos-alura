/**
 * 
 */
package com.thalespf.demos.oo.domain;


/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 * 
 */
public class Divida {

	private double total;
	private String credor;

	private Pagamentos pagamentos = new Pagamentos();
	
	private Documento documentoCredor;
	
	public void setDocumentoCredor(Documento documentoCredor) {
		this.documentoCredor = documentoCredor;
	}
	
	public Documento getDocumentoCredor() {
		return documentoCredor;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public double getTotal() {
		return total;
	}

	public String getCredor() {
		return credor;
	}

	public void setCredor(String credor) {
		this.credor = credor;
	}

	public void registra(Pagamento pagamento) {
		pagamentos.registra(pagamento);
	}

	public double getValorAPagar() {
		return total - pagamentos.getValorPago();
	}

}
