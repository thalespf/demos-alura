package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {

/*		Conta conta = new Conta();
		conta.setTitular("Ana Maria");
		conta.setBanco("Itau");
		conta.setNumero("54321");
		conta.setAgencia("111");*/
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Escola");
		movimentacao.setMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("300.9"));

		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Conta conta = manager.find(Conta.class, 1);
		movimentacao.setConta(conta);

		//manager.persist(conta);
		manager.persist(movimentacao);

		manager.getTransaction().commit();
		manager.close();

	}
}