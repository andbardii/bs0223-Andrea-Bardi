package com.app.about.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.about.model.Utente;
import com.app.about.repository.UtenteDAO;


@Service
public class UtenteService {

	@Autowired UtenteDAO uDAO;
	@Autowired @Qualifier("utente") private ObjectProvider<Utente> edificioProvider;
	
	public Utente salvaUtenteRubrica(String nome, String email, int telefono, String immagine) {
		Utente u = edificioProvider.getObject();
		u.setNome(nome);
		u.setEmail(email);
		u.setTelefono(telefono);
		u.setImmagine(immagine);
		uDAO.save(u);
		return u;
	}
	public List<Utente> findAllRubrica(){
		return (List<Utente>) uDAO.findAll();
	}
}
