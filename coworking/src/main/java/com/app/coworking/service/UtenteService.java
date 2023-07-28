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

	public Utente creaUtente(String nome, String username, String email) {
		Utente u = utenteProvider.getObject();
		u.setNome(nome);
		u.setUsername(username);
		u.setEmail(email);
		utenteDAO.save(u);
		log.info("Utente " + u.getNome() + " salvato nel database.");
		return u;
	}
}
