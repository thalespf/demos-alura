/**
 * 
 */
package com.thalespf.demos.oo.manager;

import com.thalespf.demos.oo.domain.Divida;
import com.thalespf.demos.oo.domain.Documento;
import com.thalespf.demos.oo.domain.Pagamento;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class BalancoEmpresa {
	
    private ArmazenadorDeDividas dividas;

    public BalancoEmpresa(ArmazenadorDeDividas dividas) {
      this.dividas = dividas;
    }
    
	public void registraDivida(Divida divida) {
		dividas.salva(divida);
	}
	
	public void pagaDivida(Documento documentoCredor, Pagamento pagamento) {
		Divida divida = dividas.carrega(documentoCredor);
		if(divida != null) {
			divida.registra(pagamento);			
		}
		dividas.salva(divida);
	}

}
