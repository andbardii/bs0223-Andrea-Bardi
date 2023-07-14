package com.cat.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utenti")
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long nTessera;
	
	@Column(name = "name", nullable = false)
	String nome;
	
	@Column(name = "lastname", nullable = false)
	String cognome;
	
	@Column(name = "dateBirth", nullable = false)
	LocalDate dataNascita;

	public Utente(String nome, String cognome, LocalDate dataNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
	}
	
	public Utente() {
		super();
	}

	public Long getnTessera() {
		return nTessera;
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

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	@Override
	public String toString() {
		return "Utente [nTessera=" + nTessera + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita="
				+ dataNascita + "]";
	}
	
}
