package it.prova.gestionecompagnia.dao.impiegato;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import it.prova.gestionecompagnia.dao.AbstractMySQLDAO;
import it.prova.gestionecompagnia.model.Compagnia;
import it.prova.gestionecompagnia.model.Impiegato;

public class ImpiegatoDAOImpl extends AbstractMySQLDAO implements ImpiegatoDAO {

	public ImpiegatoDAOImpl(Connection connection) {
		super(connection);
	}
	
	@Override
	public List<Impiegato> list() throws Exception {

		return null;
	}

	@Override
	public Impiegato get(Long idInput) throws Exception {

		return null;
	}

	@Override
	public int update(Impiegato input) throws Exception {

		return 0;
	}

	@Override
	public int insert(Impiegato input) throws Exception {

		return 0;
	}

	@Override
	public int delete(Impiegato input) throws Exception {

		return 0;
	}

	@Override
	public List<Impiegato> findByExample(Impiegato input) throws Exception {

		return null;
	}

	@Override
	public List<Impiegato> findAllByCompagnia(Compagnia compagniaInput) throws Exception {

		return null;
	}

	@Override
	public int countByDataFondazioneCompagniaGreaterThan(Date dataFondazoneInput) throws Exception {

		return 0;
	}

	@Override
	public List<Impiegato> findAllByCompagniaConFatturatoMaggioreDi(int fatturatoInput) throws Exception {

		return null;
	}

	@Override
	public List<Impiegato> findAllErroriAssunzione() throws Exception {

		return null;
	}

}
