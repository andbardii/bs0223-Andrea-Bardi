package com.app.coworking.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.coworking.model.Utente;
import com.app.coworking.repository.UtenteDAO;

@Service
public class UtenteService {

	private Logger log = LoggerFactory.getLogger(UtenteService.class);
	
	@Autowired UtenteDAO utenteDAO;
	@Autowired @Qualifier("utente") private ObjectProvider<Utente> utenteProvider;

	public Utente registraUtente(String nome, String username, String email) {
		Utente u = utenteProvider.getObject();
		u.setNome(nome);
		u.setUsername(username);
		u.setEmail(email);
		utenteDAO.save(u);
		log.info("Utente " + u.getNome() + " salvato nel database.");
		return u;
	}
	
	public Utente findById(long id) {
		Utente res = utenteDAO.findById(id).get();
		if(res.equals(null)) {
			log.info("Nessun utente trovato!");
			return null;
		}else {
			return res;
		}
	}
	
	public Iterable<Utente> findAll() {
		utenteDAO.findAll().forEach(u -> log.info(u.toString()));
		return utenteDAO.findAll();
	}

	public void update(long id) {
		utenteDAO.save(findById(id));
	}
	
	public void remove(long id) {
		utenteDAO.delete(findById(id));
	}
	
}
