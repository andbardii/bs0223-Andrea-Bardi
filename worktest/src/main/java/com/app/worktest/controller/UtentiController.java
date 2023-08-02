package com.app.worktest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.worktest.model.Utente;
import com.app.worktest.service.UtenteService;

@RestController
@RequestMapping("/utente")
public class UtentiController {

	@Autowired UtenteService utenteSvc;

	@GetMapping
	public ResponseEntity<List<Utente>> getAll() {
		List<Utente> listaUtenti = utenteSvc.findAll();
		ResponseEntity<List<Utente>> resp = new ResponseEntity<List<Utente>>(listaUtenti, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getByID(@PathVariable Long id) {
		Utente u = utenteSvc.findById(id);
		return new ResponseEntity<Utente>(u, HttpStatus.OK);
		
		
	}
	
	@PostMapping
	public ResponseEntity<?> registra(@RequestBody Utente u){
		
			return new ResponseEntity<Utente>(utenteSvc.registraUtente(u.getNome(), u.getUsername(), u.getEmail()), HttpStatus.CREATED);
	}
}
