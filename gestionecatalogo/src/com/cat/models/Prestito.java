package com.cat.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "prestiti")
@NamedQuery(name = "findDelayPrestitiBook", query = "SELECT p.libroPrestato FROM Prestito p WHERE p.dataRestituzione < p.dataFine OR p.dataFine IS NULL")
@NamedQuery(name = "findDelayPrestitiMag", query = "SELECT p.rivistaPrestata FROM Prestito p WHERE p.dataRestituzione < p.dataFine OR p.dataFine IS NULL")
@NamedQuery(name = "findUsersPresitiBook", query = "SELECT p.libroPrestato FROM Prestito p JOIN p.utente u WHERE u.nTessera = :nTessera")
@NamedQuery(name = "findUsersPresitiMag", query = "SELECT p.rivistaPrestata FROM Prestito p JOIN p.utente u WHERE u.nTessera = :nTessera")
public class Prestito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Utente utente;
	
	@ManyToOne
	private Book libroPrestato;
	
	@ManyToOne
	private Magazine rivistaPrestata;
	
	private LocalDate dataInizio;
	private LocalDate dataRestituzione;
	private LocalDate dataFine;

	public Prestito() {
		super();
	}

	public Prestito(Utente utente, Book libroPrestato, Magazine rivistaPrestata, LocalDate dataInizio,
			LocalDate dataRestituzione) {
		super();
		this.utente = utente;
		this.libroPrestato = libroPrestato;
		this.rivistaPrestata = rivistaPrestata;
		this.dataInizio = dataInizio;
		this.dataRestituzione = dataRestituzione;
	}

	public Long getId() {
		return id;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Book getLibriPrestati() {
		return libroPrestato;
	}

	public void setLibriPrestati(Book libroPrestato) {
		this.libroPrestato = libroPrestato;
	}

	public Magazine getRivistePrestati() {
		return rivistaPrestata;
	}

	public void setRivistePrestati(Magazine rivistaPrestata) {
		this.rivistaPrestata = rivistaPrestata;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDate getDataRestituzione() {
		return dataRestituzione;
	}

	public void setDataRestituzione(LocalDate dataRestituzione) {
		this.dataRestituzione = dataRestituzione;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}

	@Override
	public String toString() {
		return "Prestito [id=" + id + ", utente=" + utente + ", libriPrestati=" + libroPrestato + ", rivistePrestati="
				+ rivistaPrestata + ", dataInizio=" + dataInizio + ", dataRestituzione=" + dataRestituzione
				+ ", dataFine=" + dataFine + "]";
	}
	
	
}
