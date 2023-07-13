package com.event.models;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.event.enums.TipoDiEvento;

@Entity
@Table(name = "eventi") 
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titolo", nullable = false)
	private String titolo;
	
	@Column(name = "dataEvento", nullable = false)
	private LocalDate dataEvento;
	
	@Column(name = "descrizione", nullable = false)
	private String descrizione;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipoEvento", nullable = false)
	private TipoDiEvento tipoEvento;
	
	@Column(name = "numeroMassimoPartecipanti", nullable = false)
	private Integer numeroMassimoPartecipanti;
	
	@Column(name = "partecipazioni", nullable = false)
	private Set<Partecipazione> partecipazioni;

	@Column(name = "numeroMassimoPartecipanti", nullable = false)
	private Location location;
	
	public Evento() {
		super();
	}

	public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoDiEvento tipoEvento,
			Integer numeroMassimoPartecipanti, Set<Partecipazione> partecipazioni, Location location) {
		super();
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
		this.partecipazioni = partecipazioni;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public TipoDiEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoDiEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public Integer getNumeroMassimoPartecipanti() {
		return numeroMassimoPartecipanti;
	}

	public void setNumeroMassimoPartecipanti(Integer numeroMassimoPartecipanti) {
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}

	public Set<Partecipazione> getPartecipazioni() {
		return partecipazioni;
	}

	public void setPartecipazioni(Set<Partecipazione> partecipazioni) {
		this.partecipazioni = partecipazioni;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", titolo=" + titolo + ", dataEvento=" + dataEvento + ", descrizione=" + descrizione
				+ ", tipoEvento=" + tipoEvento + ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti
				+ ", partecipazioni=" + partecipazioni + ", location=" + location + "]";
	}
		
}
