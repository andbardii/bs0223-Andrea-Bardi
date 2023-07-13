package com.event.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.event.enums.Stato;

@Entity
public class Partecipazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "persona", nullable = false)
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Persona persona;
	
	@Column(name = "evento", nullable = false)
	private Evento evento;
	
	@Column(name = "persona", nullable = false)
	private Stato stato;

	public Partecipazione() {
		super();
	}

	public Partecipazione(Persona persona, Evento evento, Stato stato) {
		super();
		this.persona = persona;
		this.evento = evento;
		this.stato = stato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	@Override
	public String toString() {
		return "Partecipazione [id=" + id + ", persona=" + persona + ", evento=" + evento + ", stato=" + stato + "]";
	}
			
	
}
