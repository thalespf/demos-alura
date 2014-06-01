package com.thalespf.demo.leilao.dominio;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LeilaoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNaoDeveAceitar2LancesSeguidosDoMesmoUsuario() {
		Usuario usuario1 = new Usuario("Maria");
		
		Leilao leilao = new Leilao("PS3");
		leilao.propoe(new Lance(usuario1, 250.));
		leilao.propoe(new Lance(usuario1, 1250.));
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(250., leilao.getLances().get(0).getValor(), 0.00001);
	}

	@Test
	public void testNaoDeveAceitarMaisQue5LancesDoMesmoUsuario() {
		Usuario usuario1 = new Usuario("Maria");
		Usuario usuario2 = new Usuario("José");
		
		Leilao leilao = new Leilao("PS3");
		leilao.propoe(new Lance(usuario1, 150.));
		leilao.propoe(new Lance(usuario2, 1250.));
		leilao.propoe(new Lance(usuario1, 250.));
		leilao.propoe(new Lance(usuario2, 1250.));
		leilao.propoe(new Lance(usuario1, 350.));
		leilao.propoe(new Lance(usuario2, 1250.));
		leilao.propoe(new Lance(usuario1, 650.));
		leilao.propoe(new Lance(usuario2, 1250.));
		leilao.propoe(new Lance(usuario1, 450.));
		leilao.propoe(new Lance(usuario2, 1250.));
		
		leilao.propoe(new Lance(usuario1, 2250.));
		
		List<Lance> lances = leilao.getLances();
		assertEquals(10, lances.size());
		assertEquals(1250., lances.get(lances.size() - 1).getValor(), 0.00001);
	}
}
