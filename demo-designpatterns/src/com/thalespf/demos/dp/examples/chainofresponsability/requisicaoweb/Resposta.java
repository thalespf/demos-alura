/**
 * 
 */
package com.thalespf.demos.dp.examples.chainofresponsability.requisicaoweb;

import com.thalespf.demos.dp.domain.Conta;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public interface Resposta {
	
	public String responde(Conta conta, Requisicao requisicao);

}
