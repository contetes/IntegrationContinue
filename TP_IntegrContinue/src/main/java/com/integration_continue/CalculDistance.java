package com.integration_continue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.connectsql.JDBCConfigSol1;

/**
 * Servlet implementation class Distance
 */
public class CalculDistance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(CalculDistance.class.getName());
	private static final String SORTIE = "Une des villes n'existe pas dans la base de données, ou est mal orthographiée.";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculDistance() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("erreur", SORTIE);
		// Recuperation donnees du formulaire
		String villeUn = request.getParameter("villeUn");
		String villeDeux = request.getParameter("villeDeux");

		Boolean firstVerify = false;
		Boolean secondVerify = false;
		try {
			firstVerify = JDBCConfigSol1.verifyCityName(villeUn);
			secondVerify = JDBCConfigSol1.verifyCityName(villeDeux);
		} catch (SQLException e) {
			LOGGER.log(Level.INFO, e.toString());
		}

		if (!firstVerify || !secondVerify) {
			String erreur = SORTIE;
			request.setAttribute("distance", erreur);
		} else {
			double distance = getDistance(villeUn, villeDeux);
			request.setAttribute("distance", ""+distance);

		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Distance.jsp").forward(request, response);
	}

	private static double getDistance(String villeUn, String villeDeux) {
		double latitudeUn = 0;
		double latitudeDeux = 0;
		double longitudeUn = 0;
		double longitudeDeux = 0;
		try {
			// Get latitudes
			latitudeUn = JDBCConfigSol1.getLatitude(villeUn) * Math.PI / 180;
			latitudeDeux = JDBCConfigSol1.getLatitude(villeDeux) * Math.PI / 180;
			// Get longitudes
			longitudeUn = JDBCConfigSol1.getLongitude(villeUn) * Math.PI / 180;
			longitudeDeux = JDBCConfigSol1.getLongitude(villeDeux) * Math.PI / 180;
			double rayon = 6371;
			// Distance calculation
			double calcul = rayon
					* Math.acos(Math.cos(latitudeUn) * Math.cos(latitudeDeux) * Math.cos(longitudeDeux - longitudeUn)
							+ Math.sin(latitudeUn) * Math.sin(latitudeDeux));
			double distance = Math.round(calcul * 100) / 100;
			return distance;
		} catch (SQLException e1) {
			LOGGER.log(Level.INFO, e1.toString());
			return 0;
		}
	}

}