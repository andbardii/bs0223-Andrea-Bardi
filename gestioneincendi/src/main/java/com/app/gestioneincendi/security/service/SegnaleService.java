package com.app.gestioneincendi.security.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.app.gestioneincendi.security.entity.Segnale;
import com.app.gestioneincendi.security.repository.SegnaliRepository;

public class SegnaleService {

	Logger log = LoggerFactory.getLogger(SegnaleService.class);
	
	@Autowired SegnaliRepository DAO;
	
	@Autowired @Qualifier("segnale") private ObjectProvider<Segnale> provider;

	// POST METHODS
	public Segnale addSegnale(String question) {
				
		Segnale s = provider.getObject();
		DAO.save(s);
		log.info("Segnale Aggiunto: " + s.toString());
		return s;
	}

	// GET METHODS
	public Segnale findById(long id) {
		Segnale s = DAO.findById(id).get();
		log.info("Segnale Trovato: " + s.toString());
		log.info(s.toString());
		return s;
	}
			
	public List<Segnale> findAll(){
		List<Segnale> l = (List<Segnale>)DAO.findAll();
		log.info("Segnali Trovati: ");
		l.forEach(s -> log.info(s.toString()));
		return l;
	}
}
