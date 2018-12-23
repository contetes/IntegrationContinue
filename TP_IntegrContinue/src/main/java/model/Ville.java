package model;

public class Ville {
	// Variables
	private String codeCommune;
	private String nomCommune;
	private String codePostal;
	private String libelleAcheminement;
	private String complementAdresse;
	private String latitude;
	private String longitude;
	
	public Ville() {
		// implicit constructor
	}

	//Getters
	public String getCodeCommune() {
		return codeCommune;
	}

	public String getNomCommune() {
		return nomCommune;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public String getLibelleAcheminement() {
		return libelleAcheminement;
	}

	public String getComplementAdresse() {
		return complementAdresse;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	// Setters
	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public void setLibelleAcheminement(String libelleAcheminement) {
		this.libelleAcheminement = libelleAcheminement;
	}

	public void setComplementAdresse(String complementAdresse) {
		this.complementAdresse = complementAdresse;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
