package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class VilleTest {
	private static String nomCommune;
	private static String codeCommune;
	private static String codePostal;
	private static String libelleAcheminement;
	private static String complementAdresse;
	private static String latitude;
	private static String longitude;
	private static Ville ville = new Ville();

	@Test
	public void testGetCodeCommune() {
		codeCommune = "75056";
		ville.setCodeCommune("75056");
		assertEquals(codeCommune, ville.getCodeCommune());
	}

	@Test
	public void testGetNomCommune() {
		nomCommune = "Paris";
		ville.setNomCommune("Paris");
		assertEquals(nomCommune, ville.getNomCommune());
	}

	@Test
	public void testGetCodePostal() {
		codePostal = "75001";
		ville.setCodePostal(codePostal);
		assertEquals(codePostal, ville.getCodePostal());
	}

	@Test
	public void testGetLibelleAcheminement() {
		libelleAcheminement = "Paris";
		ville.setLibelleAcheminement(libelleAcheminement);
		assertEquals(libelleAcheminement, ville.getLibelleAcheminement());
	}

	@Test
	public void testGetComplementAdresse() {
		complementAdresse = "";
		ville.setComplementAdresse(complementAdresse);
		assertEquals(complementAdresse, ville.getComplementAdresse());
	}

	@Test
	public void testGetLatitude() {
		latitude = "48.844955";
		ville.setLatitude(latitude);
		assertEquals(latitude, ville.getLatitude());
	}

	@Test
	public void testGetLongitude() {
		longitude = "2.3760848";
		ville.setLongitude(longitude);
		assertEquals(longitude, ville.getLongitude());
	}

}
