package it.prova.gestionecompagnia.test;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

//			// TEST METODO findAllByDataAssunzioneMaggioreDi()#################
//			testFindAllByDataAssunzioneMaggioreDi(compagniaDAOInstance);

//			 //TEST METODO findAllByRagioneSocialeContiene()############
//			testFindAllByRagioneSocialeContiene(compagniaDAOInstance);

			// TEST METODO findAllByCodiceFiscaleImpiegatoContiene()###########
//			testFindAllByCodiceFiscaleImpiegatoContiene(compagniaDAOInstance);

//			// METODI IMPIEGATO----------------------------------------------
			// TEST METODO insert()##########################################
//			testInsertImpiegato(impiegatoDAOInstance);

//			// TEST METODO findByExample()##################################
//			testFindByExampleImpiegato(impiegatoDAOInstance);

//			// TEST METODO get()###########################################
//			testGetImpiegato(impiegatoDAOInstance);

			// TEST METODO update()##########################################
//			testUpdateImpiegato(impiegatoDAOInstance);

//			// TEST METODO delete()########################################
//			testDeleteImpiegato(impiegatoDAOInstance);

//			// TEST METODO findAllByCompagnia()#############################
//			testFindAllByCompagnia(impiegatoDAOInstance);

			// TEST METODO findAllByCompagniaConFatturatoMaggioreDi()##########
//			testFindAllByCompagniaConFatturatoMaggioreDi(impiegatoDAOInstance);

//			// TEST METODO countByDataFondazioneCompagniaGreaterThan()##########
//			testCountByDataFondazioneCompagniaGreaterThan(impiegatoDAOInstance);

//			//TEST METODO FindAllErroriAssunzione()#########################
//			testFindAllErroriAssunzione(impiegatoDAOInstance);

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

	private static void testFindByExampleImpiegato(CompagniaDAO compagniaDAOInstance) throws Exception {
		System.out.println("testFindByExample inizio.......");

		Compagnia compagniaDaTrovare = new Compagnia();
		compagniaDaTrovare.setRagioneSociale("p");

		for (Compagnia compagniaItem : compagniaDAOInstance.findByExample(compagniaDaTrovare)) {
			System.out.println(compagniaItem);
		}
		System.out.println("testFindByExample fine.......");
	}

	private static void testFindAllByDataAssunzioneMaggioreDi(CompagniaDAO compagniaDAOInstance) throws Exception {
		System.out.println("testFindAllByDataAssunzioneMaggioreDi inizio.......");

		Date dataPerRicerca = new SimpleDateFormat("dd-MM-yyyy").parse("01-02-2019");

		for (Compagnia compagniaItem : compagniaDAOInstance.findAllByDataAssunzioneMaggioreDi(dataPerRicerca)) {
			System.out.println(compagniaItem);
		}
		System.out.println("testFindAllByDataAssunzioneMaggioreDi fine.......");
	}

	private static void testFindAllByRagioneSocialeContiene(CompagniaDAO compagniaDAOInstance) throws Exception {
		System.out.println("testFindAllByDataAssunzioneMaggioreDi inizio.......");

		String ragioneSocialeInput = "c";

		for (Compagnia compagniaItem : compagniaDAOInstance.findAllByRagioneSocialeContiene(ragioneSocialeInput)) {
			System.out.println(compagniaItem);
		}
		System.out.println("testFindAllByDataAssunzioneMaggioreDi fine.......");
	}

	private static void testFindAllByCodiceFiscaleImpiegatoContiene(CompagniaDAO compagniaDAOInstance)
			throws Exception {
		System.out.println("testFindAllByCodiceFiscaleImpiegatoContiene inizio.......");

		String codiceFiscaleInput = "F";

		for (Compagnia compagniaItem : compagniaDAOInstance
				.findAllByCodiceFiscaleImpiegatoContiene(codiceFiscaleInput)) {
			System.out.println(compagniaItem);
		}
		System.out.println("testFindAllByCodiceFiscaleImpiegatoContiene fine.......");
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

	private static void testFindByExampleImpiegato(ImpiegatoDAO impiegatoDAOInstance) throws Exception {
		System.out.println("testFindByExampleImpiegato inizio.......");

		Impiegato impiegatoDaTrovare = new Impiegato();
		impiegatoDaTrovare.setNome("nn");

		for (Impiegato impiegatoItem : impiegatoDAOInstance.findByExample(impiegatoDaTrovare)) {
			System.out.println(impiegatoItem);
		}
		System.out.println("testFindByExampleImpiegato fine.......");
	}

	private static void testDeleteImpiegato(ImpiegatoDAO impiegatoDAOInstance) throws Exception {
		System.out.println(".......testInsertImpiegato inizio.............");

		Impiegato impiegatoDaEliminare = impiegatoDAOInstance.list().get(3);

		int quantiImpiegatiIEliminati = impiegatoDAOInstance.delete(impiegatoDaEliminare);
		if (quantiImpiegatiIEliminati < 1)
			throw new RuntimeException("testDeleteImpiegato : FAILED");

		System.out.println(".......testInsertImpiegato fine: PASSED.............");
	}

	private static void testFindAllByCompagnia(ImpiegatoDAO impiegatoDAOInstance) throws Exception {
		System.out.println("testFindAllByCompagnia inizio.......");

		Date dataFondazione = new SimpleDateFormat("dd-MM-yyyy").parse("17-05-2022");

		Compagnia compagniaPerProva = new Compagnia(5L, "Pear", 50000000, dataFondazione);

		for (Impiegato impiegatoItem : impiegatoDAOInstance.findAllByCompagnia(compagniaPerProva)) {
			System.out.println(impiegatoItem);
		}
		System.out.println("testFindAllByCompagnia fine.......");
	}

	private static void testFindAllByCompagniaConFatturatoMaggioreDi(ImpiegatoDAO impiegatoDAOInstance)
			throws Exception {
		System.out.println("testFindAllByCompagniaConFatturatoMaggioreDi inizio.......");

		int fatturatoInput = 10000000;

		for (Impiegato impiegatoItem : impiegatoDAOInstance.findAllByCompagniaConFatturatoMaggioreDi(fatturatoInput)) {
			System.out.println(impiegatoItem);
		}
		System.out.println("testFindAllByCompagniaConFatturatoMaggioreDi fine.......");
	}

	private static void testCountByDataFondazioneCompagniaGreaterThan(ImpiegatoDAO impiegatoDAOInstance)
			throws Exception {
		System.out.println("testCountByDataFondazioneCompagniaGreaterThan inizio.......");

		Date dataFondazione = new SimpleDateFormat("dd-MM-yyyy").parse("17-05-1970");

		System.err.println(impiegatoDAOInstance.countByDataFondazioneCompagniaGreaterThan(dataFondazione));
		System.out.println("testCountByDataFondazioneCompagniaGreaterThan fine.......");
	}

	private static void testFindAllErroriAssunzione(ImpiegatoDAO impiegatoDAOInstance) throws Exception {
		System.out.println("testFindAllErroriAssunzione inizio.......");

		int fatturatoInput = 10000000;

		for (Impiegato impiegatoItem : impiegatoDAOInstance.findAllErroriAssunzione()) {
			System.out.println(impiegatoItem);
		}
		System.out.println("testFindAllErroriAssunzione fine.......");
	}

}