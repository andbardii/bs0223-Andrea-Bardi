package com.app.coworking.service;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.coworking.model.Postazione;
import com.app.coworking.model.Prenotazione;
import com.app.coworking.model.Utente;
import com.app.coworking.repository.PrenotazioneDAO;

@Service
public class PrenotazioneService {

	private Logger log = LoggerFactory.getLogger(PrenotazioneService.class);
	
	@Autowired PrenotazioneDAO prenotazioneDAO;
	@Autowired @Qualifier("prenotazione") private ObjectProvider<Prenotazione> prenotazioneProvider;

	public Prenotazione creaPrenotazione(Postazione postazione, Utente utente, LocalDate data) {
		Prenotazione p = prenotazioneProvider.getObject();
		p.setPostazione(postazione);
		p.setUtente(utente);
		p.setData(data);
		prenotazioneDAO.save(p);
		log.info("Prenotazione presso la postazione " + p.getPostazione().getCodice() + " in data " + p.getData() + " salvata nel database.");
		return p;
	}
}
