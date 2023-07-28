package com.app.coworking.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.coworking.model.Edificio;
import com.app.coworking.model.Postazione;
import com.app.coworking.model.TipoPostazione;
import com.app.coworking.repository.PostazioneDAO;

@Service
public class PostazioneService {

	private Logger log = LoggerFactory.getLogger(PostazioneService.class);
	
	@Autowired PostazioneDAO postazioneDAO;
	@Autowired @Qualifier("postazione") private ObjectProvider<Postazione> edificioProvider;

	public Postazione creaPostazione(String descrizione, TipoPostazione tipo, int posti, Edificio edificio) {
		Postazione p = edificioProvider.getObject();
		p.setDescrizione(descrizione);
		p.setTipo(tipo);
		p.setPosti(posti);
		p.setEdificio(edificio);
		postazioneDAO.save(p);
		log.info("Postazione " + p.getCodice() + " di tipo " + p.getTipo() + " salvata nel database.");
		return p;
	}
}
