package com.integration_continue;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.*;

import db.connectsql.JDBCConfigSol1;

public class VilleFranceDAOImpl {
	/**
	 * Logger
	 */
	private static final Logger LOGGER = Logger.getLogger(VilleFranceDAOImpl.class.getName());

	public void findVille() throws SQLException {
		Connection con = JDBCConfigSol1.getConnection();
		String query = "SELECT * FROM ville_france";
		try (Statement statement = con.createStatement(); ResultSet resultSet = statement.executeQuery(query)){
			while(resultSet.next()){
				LOGGER.info("nom commune : " + resultSet.getString("Nom_commune"));
			}
					
		} catch(SQLException e){
			LOGGER.log(Level.INFO, "Statement or resulSet encountered a problem");
		} 
	}

}