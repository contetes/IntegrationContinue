package db.connectsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
	private static final String DB_USER = "stella";
	private static final String DB_PSD = "decker";
	static Connection connection = null;

	private JDBCConfigSol1() {
	}

	/**
	 * Connection to database
	 * 
	 * @return the connection
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName(DB_DRIVER);
			connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PSD);

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
	 */
	public static Boolean verifyCityName(String name) throws SQLException {
		ResultSet result = null;
		try {
			Boolean response = false;
			result = selectAllFromCityWithName(name);
			while (result.next()) {
				response = result.getString("Nom_commune").equals(name);
			}
			return response;
		} catch (SQLException e) {
			LOGGER.warning("Erreur SQL");
			return false;
		} catch (NullPointerException e1) {
			LOGGER.warning("La connexion est nulle");
			return false;
		} finally {
			result.close();
		}
	}

	public static ResultSet selectAllFromCityWithName(String name) throws SQLException{
		PreparedStatement selectSQL = null;
		try {
			selectSQL = getConnection().prepareStatement("SELECT * FROM ville_france WHERE Nom_commune = ?");
			selectSQL.setString(1, name);
			return selectSQL.executeQuery();
		} catch (NullPointerException e) {
			LOGGER.log(Level.INFO, e.toString());
			return null;
		} finally {
			selectSQL.close();
		}
	}

	/**
	 * Get the city latitude
	 * @param name of the city
	 * @return the latitude
	 * @throws SQLException
	 */
	public static double getLatitude(String name) throws SQLException {
		ResultSet result = null;
		String latitude = "";
		result = selectAllFromCityWithName(name);
		while (result.next()){
			latitude = result.getString("Latitude");
		}
		return Double.parseDouble(latitude);
	}

	/**
	 * Get the city longitude
	 * @param name of the city
	 * @return the latitude
	 * @throws SQLException
	 */
	public static double getLongitude(String name) throws SQLException {
		ResultSet result = null;
		String longitude = "";
		result = selectAllFromCityWithName(name);
		while (result.next()){
			longitude = result.getString("Longitude");
		}
		return Double.parseDouble(longitude);
	}
	
	public static List<Ville> getListeVilles() throws SQLException{
		PreparedStatement selectSQL = null;
		ResultSet result = null;
		List<Ville> listVille = new ArrayList<>();
		try {
			selectSQL = getConnection().prepareStatement("SELECT * FROM ville_france");
			result = selectSQL.executeQuery();
			while (result.next()){
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
		} catch (NullPointerException e) {
			LOGGER.log(Level.INFO, e.toString());
			return null;
		} finally {
			selectSQL.close();
			result.close();
		}
	}
}
