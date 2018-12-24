package com.integration_continue;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class AffichageVillesTest {
	public static AffichageVilles villes;

	@BeforeClass
	public static void beforeClass(){
		villes = new AffichageVilles();
	}
	
	@Test
	public void testAffichageVilles() {
		assertEquals("AffichageVilles is not instantiated : ", "AffichageVilles", villes.getClass().getSimpleName());
	}

}
