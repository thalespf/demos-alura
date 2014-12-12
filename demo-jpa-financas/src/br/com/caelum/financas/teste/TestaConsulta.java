/**
 * 
 */
package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class TestaConsulta {

	public TestaConsulta() {
	}
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		Query query = em.createQuery("select m from Movimentacao m where m.conta = :pConta" + 
				" and m.movimentacao = :pMovimentacao " + 
				" order by m.valor desc");
		
		query.setParameter("pConta", conta);
		query.setParameter("pMovimentacao", TipoMovimentacao.SAIDA);
		
		List<Movimentacao> moviementacoes = query.getResultList();
		
		for (Movimentacao movimentacao : moviementacoes) {
			System.out.println(movimentacao);
		}
	}

}
