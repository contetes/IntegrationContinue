package com.integration_continue;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class DistanceTest {
	public static Distance distance;
	
	@BeforeClass
	public static void beforeClass(){
		distance = new Distance();
	}

	@Test
	public void testDistance() {
		assertEquals("Distance is not instantiated : ", "Distance", distance.getClass().getSimpleName());
	}

}
