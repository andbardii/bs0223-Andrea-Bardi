package com.app.cowork.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.cowork.model.Postazione;
import com.app.cowork.model.Prenotazione;
import com.app.cowork.model.Utente;

public interface PrenotazioneDAO extends CrudRepository<Prenotazione, Long> {
	
	List<Prenotazione> findByUtente(Utente utente);
	
	Prenotazione findByUtenteAndData(Utente utente, LocalDate data);
	
	List<Prenotazione> findByPostazioneAndData(Postazione postazione, LocalDate data);
	
}
