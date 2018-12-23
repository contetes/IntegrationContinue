package db.connectsql;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Ville;

public class JDBCConfigSol1 {
	/**
	 * Logger
	 */
	private static final Logger LOGGER = Logger.getLogger(JDBCConfigSol1.class.getName());
	private static final String DB_DRIVER = "org.mariadb.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mariadb://192.168.99.100/maven";
	static Connection connection = null;

	private JDBCConfigSol1() {
	}

	/**
	 * Connection to database
	 * 
	 * @return the connection
	 * @throws SQLException
	 * @throws IOException 
	 */
	public static Connection getConnection() throws SQLException, IOException {
		Connection connection = null;
		try {
			Class.forName(DB_DRIVER);
			connection = DriverManager.getConnection(DB_CONNECTION, getUser(), getPass());

		} catch (ClassNotFoundException e) {
			LOGGER.log(Level.INFO, e.getMessage());

		} catch (SQLException e1) {
			LOGGER.log(Level.INFO, e1.getMessage());
		}
		return connection;
	}

	/**
	 * Verify if the city name entered is registered in database
	 * 
	 * @param name
	 *            the city name written by the user
	 * @return true if it is registered, false if it is not
	 * @throws SQLException
	 * @throws IOException 
	 */
	public static Boolean verifyCityName(String name) throws SQLException, IOException {
		try (ResultSet result = selectAllFromCityWithName(name);) {
			Boolean response = false;
			while (result.next()) {
				response = result.getString("Nom_commune").equals(name);
			}
			return response;
		} catch (SQLException e) {
			LOGGER.warning("Erreur SQL");
			return false;
		}
	}

	public static ResultSet selectAllFromCityWithName(String name) throws SQLException, IOException {
		Connection con = getConnection();
		if (con != null) {
			try (PreparedStatement selectSQL = con
					.prepareStatement("SELECT * FROM ville_france WHERE Nom_commune = ?");) {
				selectSQL.setString(1, name);
				return selectSQL.executeQuery();
			}
		} else {
			throw new NullPointerException("La connexion n'a pas abouti.");
		}
	}

	/**
	 * Get the city latitude
	 * 
	 * @param name
	 *            of the city
	 * @return the latitude
	 * @throws SQLException
	 * @throws IOException 
	 */
	public static double getLatitude(String name) throws SQLException, IOException {
		ResultSet result = null;
		String latitude = "";
		result = selectAllFromCityWithName(name);
		while (result.next()) {
			latitude = result.getString("Latitude");
		}
		return Double.parseDouble(latitude);
	}

	/**
	 * Get the city longitude
	 * 
	 * @param name
	 *            of the city
	 * @return the latitude
	 * @throws SQLException
	 * @throws IOException 
	 */
	public static double getLongitude(String name) throws SQLException, IOException {
		ResultSet result = null;
		String longitude = "";
		result = selectAllFromCityWithName(name);
		while (result.next()) {
			longitude = result.getString("Longitude");
		}
		return Double.parseDouble(longitude);
	}

	/**
	 * Get the entire cities list with all arguments
	 * @return the list
	 * @throws SQLException
	 * @throws IOException
	 */
	public static List<Ville> getListeVilles() throws SQLException, IOException {
		Connection con = getConnection();
		List<Ville> listVille = new ArrayList<>();
		if (con != null) {
			try (PreparedStatement selectSQL = con.prepareStatement("SELECT * FROM ville_france");) {
				try (ResultSet result = selectSQL.executeQuery();) {
					while (result.next()) {
						Ville ville = new Ville();
						ville.setNomCommune(result.getString("Nom_commune"));
						ville.setCodeCommune(result.getString("Code_commune_INSEE"));
						ville.setCodePostal(result.getString("Code_postal"));
						ville.setComplementAdresse(result.getString("Ligne_5"));
						ville.setLibelleAcheminement(result.getString("Libelle_acheminement"));
						ville.setLatitude(result.getString("Latitude"));
						ville.setLongitude(result.getString("Longitude"));
						listVille.add(ville);
					}
					return listVille;
				}
			}
		} else {
			throw new NullPointerException("La connexion n'a pas abouti.");
		}
	}
	
	/**
	 * Get properties from the config.properties file
	 * @return the stream
	 * @throws FileNotFoundException 
	 * @throws IOException
	 */
	public static Properties getProperties() throws IOException{
		String rootPath = Thread.currentThread().getContextClassLoader().getResource("ressources").getPath();
		String configPath = rootPath + "config.properties";
		Properties prop = new Properties();
		prop.load(new FileInputStream(configPath));
		return prop;
	}
	
	/**
	 * Get database user
	 * @return the user
	 * @throws IOException
	 */
	public static String getUser() throws IOException {
		Properties prop = getProperties();
		return prop.getProperty("user");
	}
	
	/**
	 * Get database pwd
	 * @return the password
	 * @throws IOException
	 */
	public static String getPass() throws IOException {
		Properties prop = getProperties();
		return prop.getProperty("pass");
	}
}
