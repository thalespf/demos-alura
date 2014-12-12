package com.thalespf.demos.oo.manager;

import com.thalespf.demos.oo.domain.Divida;
import com.thalespf.demos.oo.domain.Documento;

public interface ArmazenadorDeDividas {
	public void salva(Divida divida);

	public Divida carrega(Documento documentoCredor);
}