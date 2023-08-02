package com.app.worktest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.worktest.model.Postazione;
import com.app.worktest.model.TipoPostazione;
import com.app.worktest.repository.PostazioneDAO;

@Service
public class PostazioneService {

	private Logger log = LoggerFactory.getLogger(PostazioneService.class);
	
	@Autowired EdificioService edificioSvc;
	@Autowired PostazioneDAO postazioneDAO;
	@Autowired @Qualifier("postazione") private ObjectProvider<Postazione> edificioProvider;

	public Postazione setPostazione(String descrizione, TipoPostazione tipo, int posti, long id) {
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
		Postazione res = postazioneDAO.findById(id).get();
		if(res.equals(null)) {
			log.info("Nessuna postazione trovata!");
			return null;
		}else {
			return res;
		}
	}
	
	public List<Postazione> findAll() {
		postazioneDAO.findAll().forEach(p -> log.info(p.toString()));
		return (List<Postazione>)postazioneDAO.findAll();
	}

	public void update(long id) {
		postazioneDAO.save(findById(id));
	}
	
	public void remove(long id) {
		postazioneDAO.delete(findById(id));
	}
	
	public List<Postazione> findByTipoAndCitta(TipoPostazione tipo, String citta) {
		List<Postazione> res = postazioneDAO.findByTipoAndCittaOfEdificio(tipo, citta);
		if(res.size() == 0) {
			log.info("Nessuna postazione trovata!");
			return null;
		}else {
			res.forEach(p -> log.info(p.toString()));
			return res;
		}
		
	}
	
}
