package it.prova.gestionecompagnia.dao.compagnia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.prova.gestionecompagnia.dao.*;
import it.prova.gestionecompagnia.model.Compagnia;

public class CompagniaDAOImpl extends AbstractMySQLDAO implements CompagniaDAO {

	public CompagniaDAOImpl(Connection connection) {
		super(connection);
	}

	@Override
	public List<Compagnia> list() throws Exception {
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		ArrayList<Compagnia> result = new ArrayList<Compagnia>();
		Compagnia compagniaTemp = null;

		try (Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery("select * from compagnia")) {

			while (rs.next()) {
				compagniaTemp = new Compagnia();
				compagniaTemp.setRagioneSociale(rs.getString("ragionesociale"));
				compagniaTemp.setFatturatoAnnuo(rs.getInt("fatturatoannuo"));
				compagniaTemp.setDataFondazione(rs.getDate("datafondazione"));
				compagniaTemp.setId(rs.getLong("id"));
				result.add(compagniaTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public Compagnia get(Long idInput) throws Exception {

		return null;
	}

	@Override
	public int update(Compagnia input) throws Exception {

		return 0;
	}

	@Override
	public int insert(Compagnia input) throws Exception {

		return 0;
	}

	@Override
	public int delete(Compagnia input) throws Exception {

		return 0;
	}

	@Override
	public List<Compagnia> findByExample(Compagnia input) throws Exception {

		return null;
	}

	@Override
	public List<Compagnia> findAllByDataAssunzineMaggioreDi(Date dataAssunzioneInput) throws Exception {

		return null;
	}

	@Override
	public List<Compagnia> findAllByRagioneSocialeContiene(String ragioneSocialeContieneInput) throws Exception {

		return null;
	}

	@Override
	public List<Compagnia> findAllByCodiceFiscaleImpiegatoContiene(String codiceFiscaleContieneInput) throws Exception {

		return null;
	}

}