package it.prova.gestionecompagnia.test;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

import it.prova.gestionecompagnia.connection.MyConnection;
import it.prova.gestionecompagnia.dao.Constants;
import it.prova.gestionecompagnia.dao.compagnia.CompagniaDAO;
import it.prova.gestionecompagnia.dao.compagnia.CompagniaDAOImpl;
import it.prova.gestionecompagnia.dao.impiegato.ImpiegatoDAO;
import it.prova.gestionecompagnia.dao.impiegato.ImpiegatoDAOImpl;
import it.prova.gestionecompagnia.model.Compagnia;
import it.prova.gestionecompagnia.model.Impiegato;

public class TestCompagnia {
	public static void main(String[] args) throws Exception {

		CompagniaDAO compagniaDAOInstance = null;
		ImpiegatoDAO impiegatoDAOInstance = null;

		try (Connection connection = MyConnection.getConnection(it.prova.gestionecompagnia.dao.Constants.DRIVER_NAME,
				Constants.CONNECTION_URL)) {
			compagniaDAOInstance = new CompagniaDAOImpl(connection);
			impiegatoDAOInstance = new ImpiegatoDAOImpl(connection);

			// METODI COMPAGNIA---------------------------------------------
			// TEST METODO list()###########################################
//			System.out.println("In tabella compagnia ci sono " + compagniaDAOInstance.list().size() + " elementi.");
//
//			// TEST METODO insert()#########################################
//			testInsertCompagnia(compagniaDAOInstance);

//			 TEST METODO get()#############################################
//			testGetCompagnia(compagniaDAOInstance);

//			//TEST METODO update()##########################################
//			testUpdateCompagnia(compagniaDAOInstance);

//			// TEST METODO findByExample()###################################
//			testFindByExampleImpiegato(compagniaDAOInstance);

//			// METODI IMPIEGATO----------------------------------------------
			// TEST METODO insert()##########################################
//			testInsertImpiegato(impiegatoDAOInstance);

//			// TEST METODO findByExample()##################################
//			testFindByExampleImpiegato(impiegatoDAOInstance);

//			// TEST METODO get()###########################################
//			testGetImpiegato(impiegatoDAOInstance);

			// TEST METODO update()##########################################
			testUpdateImpiegato(impiegatoDAOInstance);

		} catch (Exception e) {
		}

	}

	// METODI COMPAGNIA##########################
	private static void testInsertCompagnia(CompagniaDAO compagniaDAOInstance) throws Exception {
		System.out.println(".......testInsertCompagnia inizio.............");

		Date dataFondazione = new SimpleDateFormat("dd-MM-yyyy").parse("03-01-2022");

		int quantiElementiInseriti = compagniaDAOInstance
				.insert(new Compagnia("Pineapple love", 70000000, dataFondazione));
		if (quantiElementiInseriti < 1)
			throw new RuntimeException("testInsertCompagnia : FAILED");

		System.out.println(".......testInsertCompagnia fine: PASSED.............");
	}

	private static void testGetCompagnia(CompagniaDAO compagniaDAOInstance) throws Exception {
		System.out.println(".......testGet inizio.............");
		List<Compagnia> elencoVociPresenti = compagniaDAOInstance.list();

		Compagnia elementoCheRicercoColDAO = compagniaDAOInstance.get(1L);

		System.out.println(elementoCheRicercoColDAO);

		System.out.println(".......testGet fine: PASSED.............");
	}

	private static void testUpdateCompagnia(CompagniaDAO compagniaDAOInstance) throws Exception {
		System.out.println(".......testUpdateCompagnia inizio.............");

		Compagnia compagniaDaModificare = compagniaDAOInstance.list().get(0);
		compagniaDaModificare.setFatturatoAnnuo(65000000);

		compagniaDAOInstance.update(compagniaDaModificare);
		System.out.println(compagniaDaModificare);

		System.out.println(".......testUpdateCompagnia fine.............");
	}

	public static void testFindByExampleImpiegato(CompagniaDAO compagniaDAOInstance) throws Exception {
		System.out.println("testFindByExample inizio.......");

		Compagnia compagniaDaTrovare = new Compagnia();
		compagniaDaTrovare.setRagioneSociale("p");

		for (Compagnia compagniaItem : compagniaDAOInstance.findByExample(compagniaDaTrovare)) {
			System.out.println(compagniaItem);
		}
		System.out.println("testFindByExample fine.......");
	}

	// METODI IMPIEGATO#########################
	private static void testInsertImpiegato(ImpiegatoDAO impiegatoDAOInstance) throws Exception {
		System.out.println(".......testInsertImpiegato inizio.............");

		Date dataNascita = new SimpleDateFormat("dd-MM-yyyy").parse("05-02-1995");
		Date dataAssunzione = new SimpleDateFormat("dd-MM-yyyy").parse("03-01-2022");

		Compagnia compagniaPerId = new Compagnia();
		compagniaPerId.setId(3L);

		int quantiElementiInseriti = impiegatoDAOInstance
				.insert(new Impiegato("Carlo", "Molinari", "CRLMLN", dataNascita, dataAssunzione, compagniaPerId));
		if (quantiElementiInseriti < 1)
			throw new RuntimeException("testInsertCompagnia : FAILED");

		System.out.println(".......testInsertImpiegato fine: PASSED.............");
	}

	private static void testGetImpiegato(ImpiegatoDAO impiegatoDAOInstance) throws Exception {
		System.out.println(".......testGetImpiegato inizio.............");
		List<Impiegato> elencoVociPresenti = impiegatoDAOInstance.list();

		Impiegato elementoCheRicercoColDAO = impiegatoDAOInstance.get(1L);

		System.out.println(elementoCheRicercoColDAO);

		System.out.println(".......testGetImpiegato fine: PASSED.............");
	}

	private static void testUpdateImpiegato(ImpiegatoDAO impiegatoDAOInstance) throws Exception {
		System.out.println(".......testUpdateImpiegato inizio.............");

		Impiegato impiegatoDaModificare = impiegatoDAOInstance.list().get(0);
		impiegatoDaModificare.setNome("Pierpaolo");

		impiegatoDAOInstance.update(impiegatoDaModificare);
		System.out.println(impiegatoDaModificare);

		System.out.println(".......testUpdateImpiegato fine.............");
	}

	public static void testFindByExampleImpiegato(ImpiegatoDAO impiegatoDAOInstance) throws Exception {
		System.out.println("testFindByExampleImpiegato inizio.......");

		Impiegato impiegatoDaTrovare = new Impiegato();
		impiegatoDaTrovare.setNome("nn");

		for (Impiegato impiegatoItem : impiegatoDAOInstance.findByExample(impiegatoDaTrovare)) {
			System.out.println(impiegatoItem);
		}
		System.out.println("testFindByExampleImpiegato fine.......");
	}
}