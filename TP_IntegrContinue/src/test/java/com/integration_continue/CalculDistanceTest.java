package com.integration_continue;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class CalculDistanceTest {
	public static CalculDistance calcul;
	
	@BeforeClass
	public static void beforeClass(){
		calcul = new CalculDistance();
	}

	@Test
	public void testCalculDistance() {
		assertEquals("CalculDistance is not instantiated : ", "CalculDistance", calcul.getClass().getSimpleName());
	}

}
