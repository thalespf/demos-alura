package com.thalespf.demo.leilao.servico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.thalespf.demo.leilao.dominio.Lance;
import com.thalespf.demo.leilao.dominio.Leilao;

public class Avaliador {
	
	private double maiorLance = Double.NEGATIVE_INFINITY;
	private double menorLance = Double.POSITIVE_INFINITY;
	private double media = 0.0;
	private List<Lance> tresMaiores;
	
	public void avalia(Leilao leilao) {
		for (Lance lance : leilao.getLances()) {
			if(lance.getValor() > maiorLance)
				maiorLance = lance.getValor();
			if(lance.getValor() < menorLance)
				menorLance = lance.getValor();
			media += lance.getValor();
		}
		media = media / leilao.getLances().size();
		
		tresMaiores = new ArrayList<Lance>(leilao.getLances());
		
		Collections.sort(tresMaiores, new Comparator<Lance>() {

			public int compare(Lance o1, Lance o2) {
				if(o1.getValor() > o2.getValor()) return -1;
				if(o1.getValor() < o2.getValor()) return 1;
				return 0;
			}
		});
		
		tresMaiores = tresMaiores.subList(0, tresMaiores.size() > 3 ? 3 : tresMaiores.size());
	}
	
	public List<Lance> getTresMaiores() {
		return tresMaiores;
	}
	
	public double getMaiorLance() {
		return maiorLance;
	}
	
	public double getMenorLance() {
		return menorLance;
	}

	public double getMedia() {
		return media;
	}

}
