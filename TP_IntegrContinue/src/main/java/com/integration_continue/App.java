package com.integration_continue;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	VilleFranceDAOImpl villeFrance = new VilleFranceDAOImpl();
		villeFrance.findVille();
    }
}
