package com.app.coworking.service;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.coworking.model.Prenotazione;
import com.app.coworking.repository.PrenotazioneDAO;

@Service
public class PrenotazioneService {
	
	@Autowired PostazioneService postazioneSvc;
	@Autowired UtenteService utenteSvc;

	private Logger log = LoggerFactory.getLogger(PrenotazioneService.class);
	
	@Autowired PrenotazioneDAO prenotazioneDAO;
	@Autowired @Qualifier("prenotazione") private ObjectProvider<Prenotazione> prenotazioneProvider;

	public Prenotazione creaPrenotazione(long codice, long id, LocalDate data) {
		if(prenotazioneDAO.findByUtenteAndData(utenteSvc.findById(id), data) == null) {
			if(prenotazioneDAO.findByPostazioneAndData(postazioneSvc.findById(codice), data).size() < postazioneSvc.findById(codice).getPosti()) {
				Prenotazione p = prenotazioneProvider.getObject();
				p.setPostazione(postazioneSvc.findById(codice));
				p.setUtente(utenteSvc.findById(id));
				p.setData(data);
				prenotazioneDAO.save(p);
				log.info("Prenotazione presso la postazione " + p.getPostazione().getCodice() + "  " + p.getData() + " salvata nel database.");
				return p;
			}else {
				log.info("La postazione è piena in questa data.");
				return null;
			}
		}else {
			log.info("Hai gia una prenotazione in questa data.");
			return null;
		}
		
	}
	
	public Prenotazione findById(long id) {
		return prenotazioneDAO.findById(id).get();
	}
	
	public Iterable<Prenotazione> findAll() {
		prenotazioneDAO.findAll().forEach(p -> log.info(p.toString()));
		return prenotazioneDAO.findAll();
	}

	public void update(long id) {
		prenotazioneDAO.save(findById(id));
	}
	
	public void remove(long id) {
		prenotazioneDAO.delete(findById(id));
	}
	
}
