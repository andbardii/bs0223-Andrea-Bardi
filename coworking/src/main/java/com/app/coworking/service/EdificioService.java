package com.app.coworking.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.coworking.model.Edificio;
import com.app.coworking.repository.EdificioDAO;

@Service
public class EdificioService {

	private Logger log = LoggerFactory.getLogger(EdificioService.class);

	@Autowired EdificioDAO edificioDAO;
	@Autowired @Qualifier("edificio") private ObjectProvider<Edificio> edificioProvider;


	public Edificio creaEdificio(String nome, String indirizzo, String citta) {
		Edificio e = edificioProvider.getObject();
		e.setNome(nome);
		e.setIndirizzo(indirizzo);
		e.setCitta(citta);
		edificioDAO.save(e);
		log.info("Edificio " + e.getNome() + " all'indirizzo " + e.getIndirizzo() + " " + e.getCitta() + " salvato nel database.");
		return e;
	}
	
	public Edificio findById(long id) {
		Edificio res = edificioDAO.findById(id).get();
		if(res.equals(null)) {
			log.info("Nessun edificio trovato!");
			return null;
		}else {
			return res;
		}
	}
	
	public Iterable<Edificio> findAll() {
		edificioDAO.findAll().forEach(e -> log.info(e.toString()));
		return edificioDAO.findAll();
	}

	public void update(long id) {
		edificioDAO.save(findById(id));
	}
	
	public void remove(long id) {
		edificioDAO.delete(findById(id));
	}
}
