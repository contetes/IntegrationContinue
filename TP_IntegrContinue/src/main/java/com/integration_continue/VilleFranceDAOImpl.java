package com.integration_continue;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import connectMySQL.JDBCConfigSol1;
import connectMySQL.JDBCConfigurationSol2;


public class VilleFranceDAOImpl {
	
	public void findVille() throws SQLException {
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Connection con = JDBCConfigurationSol2.getConnection();
			statement = con.createStatement();
			
			resultSet = statement.executeQuery("SELECT * FROM ville_france");
			while(resultSet.next()){
				System.out.println("nom commune : " + resultSet.getString("Nom_commune"));
				
			}
			resultSet.close();
			statement.close();
		} catch(SQLException e){
			e.printStackTrace();
		} finally {
			statement.close();
			resultSet.close();
		}
	}

}