package com.app.cowork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.cowork.model.Prenotazione;
import com.app.cowork.service.EdificioService;
import com.app.cowork.service.PostazioneService;
import com.app.cowork.service.PrenotazioneService;
import com.app.cowork.service.UtenteService;

@RestController
@RequestMapping("/prenota")
public class PrenotaController {
	
	@Autowired EdificioService edificioSvc;
	@Autowired PostazioneService postazioneSvc;
	@Autowired PrenotazioneService prenotazioneSvc;
	@Autowired UtenteService utenteSvc;
	
	@PostMapping
	public ResponseEntity<?> prenota(@RequestBody Prenotazione p){
		try {
			return new ResponseEntity<Prenotazione>(prenotazioneSvc.prenota(p.getPostazione().getCodice(), p.getUtente().getId(), p.getData()), HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
