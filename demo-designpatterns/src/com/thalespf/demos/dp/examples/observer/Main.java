/**
 * 
 */
package com.thalespf.demos.dp.examples.observer;

import java.util.Calendar;

import com.thalespf.demos.dp.domain.ItemDaNota;
import com.thalespf.demos.dp.examples.builder.ItemDaNotaBuilder;
import com.thalespf.demos.dp.examples.builder.NotaFiscalBuilder;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		NotaFiscalBuilder builder = new NotaFiscalBuilder();
		
		builder.addAcaoListener(new Impressora());
		builder.addAcaoListener(new NotaFiscalDao());
		builder.addAcaoListener(new EnviadorDeEmail());
		builder.addAcaoListener(new Multiplicador(10.));
		
		ItemDaNotaBuilder builder2 = new ItemDaNotaBuilder();
		
		ItemDaNota itemDaNota = builder2.comValor(100.).comNome("Item 1").create();
		ItemDaNota itemDaNota2 = builder2.comValor(1000.).comNome("Item 2").create();
		ItemDaNota itemDaNota3 = builder2.comValor(1000.).comNome("Item 3").create();
		builder.paraEmpresa("Empresa Z").comCnpj("100.125.255/0000-1")
			   .comItem(itemDaNota)
			   .comItem(itemDaNota2)
			   .comItem(itemDaNota3)
			   .comObservacoes("Minhas observacoes")
			   .naData(Calendar.getInstance()).createNotaFiscal();
		
	}

}
