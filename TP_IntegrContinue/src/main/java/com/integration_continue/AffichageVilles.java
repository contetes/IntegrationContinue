package com.integration_continue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.connectsql.JDBCConfigSol1;
import model.Ville;

/**
 * Servlet implementation class AffichageVilles
 */
public class AffichageVilles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/jsp/Villes.jsp";
	private static final Logger LOGGER = Logger.getLogger(CalculDistance.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffichageVilles() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Ville> villes = new ArrayList<>();
    	try {
			villes = JDBCConfigSol1.getListeVilles();
		} catch (SQLException e) {
			LOGGER.log(Level.INFO, e.toString());
		}
    	request.setAttribute("villes", villes);
    	this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
