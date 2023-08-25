package com.app.gestioneincendi.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.gestioneincendi.model.Centro;
import com.app.gestioneincendi.repository.CentriRepository;

@Service
public class CentroService {

	Logger log = LoggerFactory.getLogger(CentroService.class);
	
	@Autowired CentriRepository DAO;
	
	@Autowired @Qualifier("centro") private ObjectProvider<Centro> provider;

	// POST METHODS
	public Centro addCentro(String question) {
			
		Centro c = provider.getObject();
		DAO.save(c);
		log.info("Centro Aggiunto: " + c.toString());
		return c;
	}

	// GET METHODS
	public Centro findById(long id) {
		Centro c = DAO.findById(id).get();
		log.info("Centro Trovato: " + c.toString());
		log.info(c.toString());
		return c;
	}
		
	public List<Centro> findAll(){
		List<Centro> l = (List<Centro>)DAO.findAll();
		log.info("Centri Trovati: ");
		l.forEach(c -> log.info(c.toString()));
		return l;
	}
}
