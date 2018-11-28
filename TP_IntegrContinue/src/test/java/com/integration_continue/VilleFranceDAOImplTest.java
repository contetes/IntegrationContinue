package com.integration_continue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import junit.framework.TestCase;

public class VilleFranceDAOImplTest extends TestCase {
	
	@Test
	public void testGetConnexion() throws SQLException {
		Connection con = db.connectsql.JDBCConfigSol1.getConnection();
		assertNotNull(con);
	}
	
}
