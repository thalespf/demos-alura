package com.thalespf.demos.oo.manager;

import java.io.File;

import com.thalespf.demos.oo.domain.Divida;
import com.thalespf.demos.oo.domain.Documento;

public class ArquivoDeDividas implements ArmazenadorDeDividas {
	private File arquivo;

	public ArquivoDeDividas(String nomeDoArquivo) {
		this.arquivo = new File(nomeDoArquivo);
	}

	@Override
	public Divida carrega(Documento documentoCredor) {
		// procura a divida no arquivo e a devolve
		return null;
	}

	@Override
	public void salva(Divida divida) {
		// grava no arquivo
	}
}