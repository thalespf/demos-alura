/**
 * 
 */
package com.thalespf.demos.dp.examples.state.conta;

import com.thalespf.demos.dp.domain.Conta;


/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public interface EstadoDaConta {

	void deposita(Conta conta, double valor);

	double saque(Conta conta, double valor);

}
