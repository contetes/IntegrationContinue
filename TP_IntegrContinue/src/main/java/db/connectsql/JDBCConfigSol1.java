package db.connectsql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

//import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.DriverManager;

public class JDBCConfigSol1 {
	/**
	 * Logger
	 */
	private static final Logger LOGGER = Logger.getLogger(JDBCConfigSol1.class.getName());
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://127.0.0.1:3306/maven?autoReconnect=true&useSSL=false&user=root&password=";
//	private static final String DB_URL="jdbc:mysql://127.0.0.1:3306/maven?autoReconnect=true";
//	private static final String DB_USER = "root";
//	private static final String DB_PSWD = "";
	static Connection connection = null;
	private JDBCConfigSol1(){}
	
	public static Connection getConnection() throws SQLException{
//		Connection connection = null;
//		MysqlDataSource mysqlDS = null;
//		
//		mysqlDS = new MysqlDataSource();
//		mysqlDS.setURL(DB_URL);
//		mysqlDS.setUser(DB_USER);
//		mysqlDS.setPassword(DB_PSWD);
//		mysqlDS.setUseSSL(false);
//		
//		try {
//			connection = mysqlDS.getConnection();
//			
//		}catch (SQLException e){
//			LOGGER.log(Level.INFO,e.getMessage());
//			
//		}
//		return connection;
		try{
			Class.forName(DB_DRIVER);
			
			if(connection == null){
				connection = DriverManager.getConnection(DB_CONNECTION);
			}
		} catch(ClassNotFoundException e){
			System.out.println("classnotfound");
			LOGGER.log(Level.INFO,e.getMessage());
			
		}catch(SQLException e1){
			System.out.println("SQLExcept");
			LOGGER.log(Level.INFO,e1.getMessage());
		}
		return connection;
	}
	
}
