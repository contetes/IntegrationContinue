package com.integration_continue;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class AccueilTest {
	public static Accueil accueil;
	
	@BeforeClass
	public static void beforeClass(){
		accueil = new Accueil();
	}

	@Test
	public void testAccueil() {
		assertEquals("Accueil is not instantiated : ", "Accueil", accueil.getClass().getSimpleName());
	}

}
