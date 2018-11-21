package connectMySQL;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

public class JDBCConfigurationSol2 {
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://127.0.0.1/maven?user=root&password=";
	
	static Connection connection = null;
	
	public static Connection getConnection(){
		try{
			Class.forName(DB_DRIVER);
			
			if(connection == null){
				connection = DriverManager.getConnection(DB_CONNECTION);
			}
		} catch(ClassNotFoundException e){
			e.printStackTrace();
			
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		return connection;
	}

}
