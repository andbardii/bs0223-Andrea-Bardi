package com.app.gestioneincendi.security.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.gestioneincendi.security.entity.Sonda;
import com.app.gestioneincendi.security.repository.SondeRepository;

@Service
public class SondaService {
	
	Logger log = LoggerFactory.getLogger(SondaService.class);
	
	@Autowired SondeRepository DAO;
	
	@Autowired @Qualifier("sonda") private ObjectProvider<Sonda> provider;

	// POST METHODS
	public Sonda addSonda(int latitudine, int longitudine) {
		
		Sonda s = provider.getObject();
		s.setLatitudine(latitudine);
		s.setLongitudine(longitudine);
		DAO.save(s);
		log.info("Sonda Aggiunta: " + s.toString());
		return s;
	}

	// GET METHODS
	public Sonda findById(long id) {
		Sonda s = DAO.findById(id).get();
		log.info("Sonda Trovata: " + s.toString());
		log.info(s.toString());
		return s;
	}
	
	public List<Sonda> findAll(){
		List<Sonda> l = (List<Sonda>)DAO.findAll();
		log.info("Sonda Trovate: ");
		l.forEach(s -> log.info(s.toString()));
		return l;
	}
}
