package com.integration_continue;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import connectMySQL.JDBCConfigSol1;
import connectMySQL.JDBCConfigurationSol2;

public class VilleFranceDAOImpl {

	public void findVille() throws SQLException {
		Connection con = JDBCConfigurationSol2.getConnection();
		String query = "SELECT * FROM ville_france";
		try (Statement statement = con.createStatement(); ResultSet resultSet = statement.executeQuery(query)){
			while(resultSet.next()){
				System.out.println("nom commune : " + resultSet.getString("Nom_commune"));
			}
					
		} catch(SQLException e){
			e.printStackTrace();
		} 
	}

}