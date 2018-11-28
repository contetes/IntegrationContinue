package com.integration_continue;

import java.sql.Connection;

import org.junit.Ignore;
import org.junit.Test;

import junit.framework.TestCase;

public class VilleFranceDAOImplTest extends TestCase {
	
	@Test
	public void testGetConnexion() {
		Connection con = db.connectsql.JDBCConfigSol1.getConnection();
		assertNotNull(con);
	}
	
	@Ignore
	public void testQueryIsCorrect(){
		VilleFranceDAOImpl villeFrance = new VilleFranceDAOImpl();
		Connection con = db.connectsql.JDBCConfigSol1.getConnection();
		
	}

}
