package it.prova.gestionecompagnia.dao.compagnia;

import java.util.List;
import java.util.Date;

import it.prova.gestionecompagnia.dao.IBaseDAO;
import it.prova.gestionecompagnia.model.Compagnia;

public interface CompagniaDAO extends IBaseDAO<Compagnia> {

	public List<Compagnia> findAllByDataAssunzioneMaggioreDi(Date dataAssunzioneInput) throws Exception;

	public List<Compagnia> findAllByRagioneSocialeContiene(String ragioneSocialeContieneInput) throws Exception;

	public List<Compagnia> findAllByCodiceFiscaleImpiegatoContiene(String codiceFiscaleContieneInput) throws Exception;

	public void findByIdEager(Compagnia compagniaInput) throws Exception;
}