package it.prova.gestionecompagnia.test;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import it.prova.gestionecompagnia.connection.MyConnection;
import it.prova.gestionecompagnia.dao.Constants;
import it.prova.gestionecompagnia.dao.compagnia.CompagniaDAO;
import it.prova.gestionecompagnia.dao.compagnia.CompagniaDAOImpl;
import it.prova.gestionecompagnia.dao.impiegato.ImpiegatoDAO;
import it.prova.gestionecompagnia.dao.impiegato.ImpiegatoDAOImpl;

public class TestCompagnia {
	public static void main(String[] args) throws Exception {

		CompagniaDAO compagniaDAOInstance = null;
		ImpiegatoDAO impiegatoDAOInstance = null;

		try (Connection connection = MyConnection.getConnection(it.prova.gestionecompagnia.dao.Constants.DRIVER_NAME,
				Constants.CONNECTION_URL)) {
			compagniaDAOInstance = new CompagniaDAOImpl(connection);
			impiegatoDAOInstance = new ImpiegatoDAOImpl(connection);

			// Prova metodo list()###########################################
			System.out.println("In tabella compagnia ci sono " + compagniaDAOInstance.list().size() + " elementi.");

		} catch (Exception e) {
		}

	}
	
	public static void testDelete(CompagniaDAO compagniaDAOInstance) {
		System.out.println("..............testDelete() inizio..............");
		
		
		System.out.println("..............testDelete() fine..............");
	}

}