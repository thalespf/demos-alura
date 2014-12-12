/**
 * 
 */
package com.thalespf.demo.leilao.servico;

import static org.junit.Assert.assertEquals;

import com.thalespf.demo.leilao.CriadorDeLeilao;
import com.thalespf.demo.leilao.dominio.Leilao;
import com.thalespf.demo.leilao.dominio.Usuario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class AvaliadorTest {

	private Avaliador avaliador;
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		avaliador = new Avaliador();
		
		usuario1 = new Usuario("Maria");
		usuario2 = new Usuario("João");
		usuario3 = new Usuario("José");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMaiorMenorLanceCrescente() {
		Leilao leilao = new CriadorDeLeilao().
					para("PS3").
					lance(usuario2, 250.).
					lance(usuario3, 300.).
					lance(usuario1, 450.).constroi();
		
		avaliador.avalia(leilao);
		
		assertEquals(250., avaliador.getMenorLance(), 0.00001);
		assertEquals(450., avaliador.getMaiorLance(), 0.00001);
	}
	
	@Test
	public void testLanceDescrescente() {
		Leilao leilao = new CriadorDeLeilao().
				para("PS3").
				lance(usuario2, 700.).
				lance(usuario3, 420.).
				lance(usuario1, 100.).constroi();
		
		avaliador.avalia(leilao);
		
		assertEquals(100., avaliador.getMenorLance(), 0.00001);
		assertEquals(700., avaliador.getMaiorLance(), 0.00001);
	}
	
	@Test
	public void testLanceAleatorio() {
		Leilao leilao = new CriadorDeLeilao().
				para("PS3").
				lance(usuario2, 200.).
				lance(usuario3, 120.).
				lance(usuario1, 700.).constroi();
		
		avaliador.avalia(leilao);
		
		assertEquals(120., avaliador.getMenorLance(), 0.00001);
		assertEquals(700., avaliador.getMaiorLance(), 0.00001);
	}
	
	@Test
	public void testMaiorMenorLanceCom1Lance() {
		Leilao leilao = new CriadorDeLeilao().
				para("PS3").
				lance(usuario2, 250.).constroi();
		
		avaliador.avalia(leilao);
		
		assertEquals(250., avaliador.getMenorLance(), 0.00001);
		assertEquals(250., avaliador.getMaiorLance(), 0.00001);
	}
	
	@Test
	public void testTresMaiores() {
		Leilao leilao = new CriadorDeLeilao().
				para("PS3").
				lance(usuario2, 250.).
				lance(usuario3, 300.).
				lance(usuario1, 450.).
				lance(usuario3, 1450.).
				lance(usuario2, 750.).constroi();
		
		avaliador.avalia(leilao);
		
		assertEquals(3, avaliador.getTresMaiores().size());
		
		assertEquals(1450., avaliador.getTresMaiores().get(0).getValor(), 0.000001);
		assertEquals(750., avaliador.getTresMaiores().get(1).getValor(), 0.000001);
		assertEquals(450., avaliador.getTresMaiores().get(2).getValor(), 0.000001);
	}
	
	@Test
	public void testTresMaioresCom2Lances() {
		Leilao leilao = new CriadorDeLeilao().
				para("PS3").
				lance(usuario2, 250.).
				lance(usuario3, 300.).constroi();
		
		avaliador.avalia(leilao);
		
		assertEquals(2, avaliador.getTresMaiores().size());
		
		assertEquals(300., avaliador.getTresMaiores().get(0).getValor(), 0.000001);
		assertEquals(250., avaliador.getTresMaiores().get(1).getValor(), 0.000001);
	}
	
	@Test
	public void testTresMaioresCom0Lances() {
		Leilao leilao = new CriadorDeLeilao().
				para("PS3").constroi();
		
		avaliador.avalia(leilao);
		
		assertEquals(0, avaliador.getTresMaiores().size());
	}
	
	@Test
	public void testCalculateMediaLances() {
		Leilao leilao = new CriadorDeLeilao().
				para("PS3").
				lance(usuario2, 250.).
				lance(usuario3, 300.).
				lance(usuario1, 450.).constroi();
		
		avaliador.avalia(leilao);
		double media = 	avaliador.getMedia();	
		
		assertEquals(media, 333.333333333333333, 0.00001);
	}

}
