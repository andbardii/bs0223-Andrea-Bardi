package com.app.gestioneincendi.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.gestioneincendi.model.Centro;
import com.app.gestioneincendi.model.Segnale;
import com.app.gestioneincendi.model.Sonda;
import com.app.gestioneincendi.repository.CentriRepository;

@Service
public class CentroService {

	Logger log = LoggerFactory.getLogger(CentroService.class);
	
	@Autowired CentriRepository DAO;
	@Autowired SegnaleService SegnaleSVC;
	
	@Autowired @Qualifier("centro") private ObjectProvider<Centro> provider;

	// POST METHODS
	public Centro addCentro() {
		log.info("Aggiungo Centro al sistema...");
		Centro c = provider.getObject();
		DAO.save(c);
		log.info("Centro " + c.getId() + " Aggiunto!");
		System.out.println();
		return c;
	}

	// GET METHODS
	public Centro findById(long id) {
		Centro c = DAO.findById(id).get();
		if (c.equals(null)) {
			log.info("Errore...");
			return null;
		}else {
		log.info("Centro " + c.getId());
		log.info(c.toString());
		return c;
		}
	}
		
	public List<Centro> findAll(){
		List<Centro> l = (List<Centro>)DAO.findAll();
		log.info("Centri Trovati: ");
		l.forEach(c -> log.info(c.toString()));
		return l;
	}
	
	public List<Sonda> showSonde(long id){
		Centro c = DAO.findById(id).get();
		List<Sonda> l = c.getSonde();
		l.forEach(s -> log.info(s.toString()));
		return l;
	}
	
	public List<Segnale> showSegnali(long id){
		Centro c = DAO.findById(id).get();
		List<Sonda> l = c.getSonde();
		System.out.println();
		log.info("Segnali del Centro " + id + ": ");
		List<Segnale> ls = new ArrayList<Segnale>();;
		for(Sonda s: l){
			log.info("Elaboro...");
			ls.addAll(SegnaleSVC.findBySonda(s));
		};
		System.out.println();
		ls.forEach(s -> log.info(s.toString()));
		return ls;
	}
	// PUT METHODS
	
	public Centro toggleSonde(Centro c) {
		DAO.save(c);
		log.info("Aggiungo al centro... ");
		return c;
	}
	
	
}
