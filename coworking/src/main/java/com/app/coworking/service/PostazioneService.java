package com.app.coworking.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.coworking.model.Postazione;
import com.app.coworking.model.TipoPostazione;
import com.app.coworking.repository.PostazioneDAO;

@Service
public class PostazioneService {

	private Logger log = LoggerFactory.getLogger(PostazioneService.class);
	
	@Autowired EdificioService edificioSvc;
	@Autowired PostazioneDAO postazioneDAO;
	@Autowired @Qualifier("postazione") private ObjectProvider<Postazione> edificioProvider;

	public Postazione creaPostazione(String descrizione, TipoPostazione tipo, int posti, long id) {
		Postazione p = edificioProvider.getObject();
		p.setDescrizione(descrizione);
		p.setTipo(tipo);
		p.setPosti(posti);
		p.setEdificio(edificioSvc.findById(id));
		postazioneDAO.save(p);
		log.info("Postazione " + p.getDescrizione() + " di tipo " + p.getTipo() + " salvata nel database.");
		return p;
	}
	
	public Postazione findById(long id) {
		return postazioneDAO.findById(id).get();
	}
	
	public Iterable<Postazione> findAll() {
		postazioneDAO.findAll().forEach(p -> log.info(p.toString()));
		return postazioneDAO.findAll();
	}

	public void update(long id) {
		postazioneDAO.save(findById(id));
	}
	
	public void remove(long id) {
		postazioneDAO.delete(findById(id));
	}
	
	public List<Postazione> findByTipoAndCitta(TipoPostazione tipo, String citta) {
		postazioneDAO.findByTipoAndCittaOfEdificio(tipo, citta).forEach(p -> log.info(p.toString()));
		return postazioneDAO.findByTipoAndCittaOfEdificio(tipo, citta);
	}
	
}
