package db.connectsql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.*;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class JDBCConfigSol1 {
	/**
	 * Logger
	 */
	private static final Logger LOGGER = Logger.getLogger(JDBCConfigSol1.class.getName());
	private static final String DB_URL="jdbc:mysql://127.0.0.1/maven";
	private static final String DB_USER = "root";
	private static final String DB_PSWD = "";
	
	private JDBCConfigSol1(){}
	
	public static Connection getConnection(){
		Connection connection = null;
		MysqlDataSource mysqlDS = null;
		
		mysqlDS = new MysqlDataSource();
		mysqlDS.setURL(DB_URL);
		mysqlDS.setUser(DB_USER);
		mysqlDS.setPassword(DB_PSWD);
		
		try {
			connection = mysqlDS.getConnection();
			
		}catch (SQLException e){
			LOGGER.log(Level.INFO, "Connection encountered a problem");
		}
		return connection;
	}
	
}
