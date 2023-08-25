package com.app.gestioneincendi.services;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.gestioneincendi.model.Segnale;
import com.app.gestioneincendi.model.Sonda;
import com.app.gestioneincendi.repository.SegnaliRepository;

@Service
public class SegnaleService {

	Logger log = LoggerFactory.getLogger(SegnaleService.class);
	
	@Autowired SegnaliRepository DAO;
	
	@Autowired @Qualifier("segnale") private ObjectProvider<Segnale> provider;

	// POST METHODS
	public Segnale addSegnale(Sonda sonda) {
		Segnale s = provider.getObject();
		s.setLongitudine(sonda.getLongitudine());
		s.setLatitudine(sonda.getLatitudine());
		s.setData(LocalDate.now());
		s.setLivellofumo(sonda.getLivellofumo());
		DAO.save(s);
		log.info("**********");
		return s;
	}

	// GET METHODS
	public Segnale findById(long id) {
		Segnale s = DAO.findById(id).get();
		log.info("Segnale " + s.getId());
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
