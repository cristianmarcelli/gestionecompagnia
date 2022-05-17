package it.prova.gestionecompagnia.model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Impiegato {

	private Long id;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private Date dataNascita;
	private Date dataAssunzione;

	public Impiegato() {
	}

	public Impiegato(Long id, String nome, String cognome, String codiceFiscale, Date dataNascita,
			Date dataAssunzione) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.dataNascita = dataNascita;
		this.dataAssunzione = dataAssunzione;
	}

	public Impiegato(String nome, String cognome, String codiceFiscale, Date dataNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.dataNascita = dataNascita;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Date getDataAssunzione() {
		return dataAssunzione;
	}

	public void setDataAssunzione(Date dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}

	@Override
	public String toString() {
		String dataNascitaString = dataNascita != null ? new SimpleDateFormat("dd/MM/yyyy").format(dataNascita)
				: " N.D.";
		String dataAssunzioneString = dataAssunzione != null ? new SimpleDateFormat("dd/MM/yyyy").format(dataAssunzione)
				: " N.D.";

		return "Impiegato [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascitaString
				+ ", dataAssunzione=" + dataAssunzioneString + "]";
	}

}
