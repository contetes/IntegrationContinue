package com.integration_continue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

import db.connectsql.JDBCConfigSol1;

public class CalculDistanceTest {
	private static CalculDistance calcul;
	private static final Logger LOGGER = Logger.getLogger(CalculDistance.class.getName());
	
	@BeforeClass
	public static void beforeClass(){
		calcul = new CalculDistance();
	}

	@Test
	public void testCalculDistance() {
		assertEquals("CalculDistance is not instantiated : ", "CalculDistance", calcul.getClass().getSimpleName());
	}

	@Test
	public void testServiceCityNameTrue() throws IOException{
		Boolean firstVerify = false;
		try {
			firstVerify = JDBCConfigSol1.verifyCityName("Angers");
			assertTrue("Angers exite dans la bdd",firstVerify);
		} catch (SQLException e) {
			LOGGER.log(Level.INFO, e.toString());
		}
	}
	
	@Test
	public void testServiceCityNameFalse() throws IOException{
		Boolean firstVerify = false;
		try {
			firstVerify = JDBCConfigSol1.verifyCityName("Inexistant");
			assertFalse("Angers exite dans la bdd",firstVerify);
		} catch (SQLException e) {
			LOGGER.log(Level.INFO, e.toString());
		}
	}
	
}
