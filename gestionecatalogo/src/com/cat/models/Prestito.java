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
import javax.persistence.OneToMany;

@Entity
public class Prestito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	Utente utente;
	
	@OneToMany(fetch = FetchType.LAZY)
	Set<Book> libriPrestati = new HashSet<Book>();
	
	@OneToMany(fetch = FetchType.LAZY)
	Set<Magazine> rivistePrestati = new HashSet<Magazine>();
	
	@Column(name = "startDate", nullable = false)
	LocalDate dataInizio;
	
	@Column(name = "restDate", nullable = false)
	LocalDate dataRestituzione;

	@Column(name = "endDate", nullable = false)
	LocalDate dataFine;

	public Prestito() {
		super();
	}

	public Prestito(Utente utente, Set<Book> libriPrestati, Set<Magazine> rivistePrestati, LocalDate dataInizio,
			LocalDate dataRestituzione, LocalDate dataFine) {
		super();
		this.utente = utente;
		this.libriPrestati = libriPrestati;
		this.rivistePrestati = rivistePrestati;
		this.dataInizio = dataInizio;
		this.dataRestituzione = dataRestituzione;
		this.dataFine = dataFine;
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

	public Set<Book> getLibriPrestati() {
		return libriPrestati;
	}

	public void setLibriPrestati(Set<Book> libriPrestati) {
		this.libriPrestati = libriPrestati;
	}

	public Set<Magazine> getRivistePrestati() {
		return rivistePrestati;
	}

	public void setRivistePrestati(Set<Magazine> rivistePrestati) {
		this.rivistePrestati = rivistePrestati;
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
		return "Prestito [id=" + id + ", utente=" + utente + ", libriPrestati=" + libriPrestati + ", rivistePrestati="
				+ rivistePrestati + ", dataInizio=" + dataInizio + ", dataRestituzione=" + dataRestituzione
				+ ", dataFine=" + dataFine + "]";
	}
	
	
}
