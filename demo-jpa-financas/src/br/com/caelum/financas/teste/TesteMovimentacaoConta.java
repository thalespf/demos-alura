/**
 * 
 */
package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class TesteMovimentacaoConta {
	
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		//manager.getTransaction().begin();
		
		Conta conta = manager.find(Conta.class, 1);
		
		//System.out.println(conta.getMovimentacoes().size());

		//manager.getTransaction().commit();
		manager.close();
		
		System.out.println(conta.getMovimentacoes().size());
	}

}
