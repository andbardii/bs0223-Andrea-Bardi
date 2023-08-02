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

import com.app.worktest.model.Prenotazione;
import com.app.worktest.service.PrenotazioneService;

@RestController
@RequestMapping("/prenotazione")
public class PrenotazioneController {
	
	@Autowired PrenotazioneService prenotazioneSvc;
	
	@GetMapping
	public ResponseEntity<List<Prenotazione>> getAll() {
		List<Prenotazione> listaPrenotazioni = prenotazioneSvc.findAll();
		ResponseEntity<List<Prenotazione>> resp = new ResponseEntity<List<Prenotazione>>(listaPrenotazioni, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getByID(@PathVariable Long id) {
		Prenotazione p = prenotazioneSvc.findById(id);
		return new ResponseEntity<Prenotazione>(p, HttpStatus.OK);
		
		
	}
	
	@PostMapping
	public ResponseEntity<?> prenota(@RequestBody Prenotazione p){
		
			return new ResponseEntity<Prenotazione>(prenotazioneSvc.prenota(p.getPostazione().getCodice(), p.getUtente().getId(), p.getData()), HttpStatus.CREATED);
	}
}
