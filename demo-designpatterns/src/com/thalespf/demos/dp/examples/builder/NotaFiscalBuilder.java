/**
 * 
 */
package com.thalespf.demos.dp.examples.builder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.thalespf.demos.dp.domain.ItemDaNota;
import com.thalespf.demos.dp.domain.NotaFiscal;
import com.thalespf.demos.dp.examples.observer.AcaoAposGerarNota;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class NotaFiscalBuilder {

	private String empresa;
	private String cnpj;
	private List<ItemDaNota> itensDaNota = new ArrayList<ItemDaNota>();
	private Calendar dataDeEmissao;
	private double valorBruto;
	private double impostos;
	private String observacoes;
	
	private List<AcaoAposGerarNota> acoes = new ArrayList<AcaoAposGerarNota>();
	
	public NotaFiscalBuilder() {
		dataDeEmissao = Calendar.getInstance();
	}
	
	public void addAcaoListener(AcaoAposGerarNota acao) {
		acoes.add(acao);
	}
	
	public NotaFiscal createNotaFiscal() {
		NotaFiscal notaFiscal = new NotaFiscal(empresa, cnpj, dataDeEmissao, 
				valorBruto, impostos, itensDaNota, observacoes);
		
		for (AcaoAposGerarNota acao : acoes) {
			acao.notaGerada(notaFiscal);
		}
		
		return notaFiscal;
	}

	public NotaFiscalBuilder paraEmpresa(String empresa) {
		this.empresa = empresa;
		return this;
	}

	public NotaFiscalBuilder comCnpj(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}

	public NotaFiscalBuilder comItem(ItemDaNota itemDaNota) {
		itensDaNota.add(itemDaNota);
		valorBruto += itemDaNota.getValor();
		impostos += valorBruto * 0.5;
		return this;
	}
	
	public NotaFiscalBuilder comObservacoes(String observacoes) {
		this.observacoes = observacoes;
		return this;
	}

	public NotaFiscalBuilder naData(Calendar data) {
		dataDeEmissao = data;
		return this;
	}

}
