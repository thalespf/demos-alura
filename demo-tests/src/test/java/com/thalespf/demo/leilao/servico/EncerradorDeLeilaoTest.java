/**
 * 
 */
package com.thalespf.demo.leilao.servico;


import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import com.thalespf.demo.leilao.CriadorDeLeilao;
import com.thalespf.demo.leilao.dominio.Leilao;
import com.thalespf.demo.leilao.infra.dao.LeilaoDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class EncerradorDeLeilaoTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void deveEncerrarLeiloesQueComecaramSemanaPassada() {
		Calendar antigo = Calendar.getInstance();
		antigo.set(1999, 12, 1);
		
		Leilao leilao1 = new CriadorDeLeilao().para("PS3").naData(antigo).constroi();
		Leilao leilao2 = new CriadorDeLeilao().para("Tv de Plasma").naData(antigo).constroi();

		List<Leilao> leiloesNoBanco = Arrays.asList(leilao1, leilao2);
		
		LeilaoDao leilaoDaoMock = mock(LeilaoDao.class);
		when(leilaoDaoMock.correntes()).thenReturn(leiloesNoBanco);
		
		EncerradorDeLeilao encerradorDeLeilao = new EncerradorDeLeilao(leilaoDaoMock);
		encerradorDeLeilao.encerra();
		
		assertTrue(leilao1.isEncerrado());
		assertTrue(leilao2.isEncerrado());
	}

}
