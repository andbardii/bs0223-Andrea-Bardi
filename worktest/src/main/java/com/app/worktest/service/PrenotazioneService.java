package com.app.worktest.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.worktest.model.Postazione;
import com.app.worktest.model.Prenotazione;
import com.app.worktest.repository.PrenotazioneDAO;

import jakarta.persistence.EntityExistsException;

@Service
public class PrenotazioneService {
	
	@Autowired PostazioneService postazioneSvc;
	@Autowired UtenteService utenteSvc;
	@Autowired EdificioService edificioSvc;

	private Logger log = LoggerFactory.getLogger(PrenotazioneService.class);
	
	@Autowired PrenotazioneDAO prenotazioneDAO;
	@Autowired @Qualifier("prenotazione") private ObjectProvider<Prenotazione> prenotazioneProvider;

	public Prenotazione prenota(long codice, long id, LocalDate data) {
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
				log.info("La postazione è piena in questa data, riprova più tardi in caso ci fossero delle rinunce.");
				throw new EntityExistsException("La postazione è piena in questa data, riprova più tardi in caso ci fossero delle rinunce.");
			}
		}else {
			log.info("Hai gia una prenotazione in questa data.");
			throw new EntityExistsException("Hai gia una prenotazione in questa data.");
		}
		
	}
	
	public Prenotazione findById(long id) {
		Prenotazione res = prenotazioneDAO.findById(id).get();
		if(res.equals(null)) {
			log.info("Nessuna prenotazione trovata!");
			return null;
		}else {
			return res;
		}
	}
	
	public List<Prenotazione> findAll() {
		return  (List<Prenotazione>) prenotazioneDAO.findAll();
	}

	public void update(long id) {
		prenotazioneDAO.save(findById(id));
	}
	
	public void remove(long id) {
		prenotazioneDAO.delete(findById(id));
	}
	
	public List<Prenotazione> findByUtente(long id) {
		List<Prenotazione> res = prenotazioneDAO.findByUtente(utenteSvc.findById(id));
		if(utenteSvc.findById(id) == null) {
			log.info("Utente inesistente!");
			return null;
		}else {
			if(res.size() == 0) {
				log.info("Nessuna prenotazione trovata per l'utente " + utenteSvc.findById(id).getNome() + "!");
				return null;
			}else {
				log.info("Prenotazioni dell'utente: " + utenteSvc.findById(id).getNome());
				res.forEach(p -> log.info(p.toString()));
				return res;
			}
		}
	}
	
	public void changeDataPrenotazione(long id, LocalDate data) {
		
		Prenotazione pre = findById(id);
		Postazione pos = pre.getPostazione();
		List<Prenotazione> res = prenotazioneDAO.findByPostazioneAndData(pos, data);
		if(res.size() < pos.getPosti()) {
			pre.setData(data);
			prenotazioneDAO.save(pre);
			log.info("Data della prenotazione aggiornata!");
		}else {
			log.info("La data selezionata è al completo, seleziona un'altra data!");
		}
	}
	
	public void checkDisponibilitaPostazione(long codice, LocalDate data) {
		
		Postazione pos = postazioneSvc.findById(codice);
		List<Prenotazione> res = prenotazioneDAO.findByPostazioneAndData(pos, data);
		
		if(res.size() < pos.getPosti()) {
			log.info("Ci sono ancora posti, prenota il tuo!");
		}else {
			log.info("Non ci sono più posti, ritenta più avanti in caso di ripensamenti!");
		}
	}
	
	public void prenotaGruppo(long codice, LocalDate data, long ...id) {
		
		int len = id.length;
		Postazione pos = postazioneSvc.findById(codice);
		List<Prenotazione> res = prenotazioneDAO.findByPostazioneAndData(pos, data);
		
		if(pos.getPosti() - res.size() >= len ) {
			for(long cid: id) {
				if(prenotazioneDAO.findByUtenteAndData(utenteSvc.findById(cid), data) == null) {
					prenota(codice, cid, data);
				}else {
					log.info("L'utente " + utenteSvc.findById(cid).getNome() + " ha gia una prenotazione nella data scelta!");
				}
			}
		}else {
			log.info("Non ci sono abbastanza posti per il gruppo!");
			int posti = (pos.getPosti() - res.size());
			log.info("Posti disponbili:  " + posti + " su " + len + " necessari.");
		}
			
	}	
	
}
