package com.app.worktest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.worktest.model.Utente;
import com.app.worktest.repository.UtenteDAO;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UtenteService {

	private Logger log = LoggerFactory.getLogger(UtenteService.class);
	
	@Autowired UtenteDAO utenteDAO;
	@Autowired @Qualifier("utente") private ObjectProvider<Utente> utenteProvider;

	public Utente registraUtente(String nome, String username, String email) {
		if(utenteDAO.existsByEmail(email)) {
			log.info("Email " + email + " gia esistente.");
			throw new EntityExistsException("Email " + email + " gia esistente.");
		}else {
		Utente u = utenteProvider.getObject();
		u.setNome(nome);
		u.setUsername(username);
		u.setEmail(email);
		utenteDAO.save(u);
		log.info("Utente " + u.getNome() + " salvato nel database.");
		return u;
		}
	}
	
	public Utente findById(long id) {
		if(utenteDAO.existsById(id)) {
			Utente res = utenteDAO.findById(id).get();
			return res;
		}else {
			log.info("Nessun utente trovato!");
			throw new EntityNotFoundException("Nessun utente trovato!");
		}
	}
	
	public List<Utente> findAll() {
		utenteDAO.findAll().forEach(u -> log.info(u.toString()));
		return (List<Utente>)utenteDAO.findAll();
	}

	public void update(long id) {
		utenteDAO.save(findById(id));
	}
	
	public void remove(long id) {
		utenteDAO.delete(findById(id));
	}
	
}
