package com.thalespf.demos.dp.examples.template;

import java.util.ArrayList;
import java.util.List;

import com.thalespf.demos.dp.domain.Banco;
import com.thalespf.demos.dp.domain.Conta;

public class Main {
	
	public static void main(String[] args) {
		Banco banco = new Banco("Banco do Brasil", "8355666666", 
				"Rua das Carmelias", "bb@gmail.com");
		
		RelatorioSimples relatorioSimples = new RelatorioSimples(banco);
		
		List<Conta> contas = new ArrayList<Conta>();
		contas.add(new Conta(1000, "Antonio", "126546"));
		contas.add(new Conta(20, "Thales", "21123"));
		contas.add(new Conta(1, "Silveira", "1223"));
		
		relatorioSimples.exibe(contas);
	}

}
