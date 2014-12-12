/**
 * 
 */
package com.thalespf.demo.leilao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class PalindromoTest {

	private String palindromo1;
	private String palindromo2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		palindromo1 = "Socorram-me subi no onibus em Marrocos";
		palindromo2 = "Anotaram a data da maratona";
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPalavraPalindroma() {
		assertEquals(true, Palindromo.ehPalindromo(palindromo1));
		assertEquals(true, Palindromo.ehPalindromo(palindromo2));
	}

}
