/**
 * 
 */
package com.thalespf.demos.dp;

import com.thalespf.demos.dp.domain.ICMS;
import com.thalespf.demos.dp.domain.ICPP;
import com.thalespf.demos.dp.domain.Imposto;
import com.thalespf.demos.dp.domain.Orcamento;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class TesteDeImpostosComplexos {
	
	public static void main(String[] args) {
		Imposto imposto = new ICMS(new ICPP());
		Orcamento orcamento = new Orcamento(3000);
		imposto.calcula(orcamento);
	}

}
