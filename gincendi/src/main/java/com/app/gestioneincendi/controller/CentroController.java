package com.app.gestioneincendi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.gestioneincendi.model.Centro;
import com.app.gestioneincendi.model.Sonda;
import com.app.gestioneincendi.model.Segnale;
import com.app.gestioneincendi.services.CentroService;

@RestController
@RequestMapping("/api/centri")
public class CentroController {
	
	@Autowired CentroService SVC;
	
	// GET API METHODS
	@GetMapping
	public ResponseEntity<List<Centro>> findAll() {
		List<Centro> list = SVC.findAll();
		ResponseEntity<List<Centro>> resp = new ResponseEntity<List<Centro>>(list, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Centro d = SVC.findById(id);
		ResponseEntity<Centro> resp = new ResponseEntity<Centro>(d, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/{id}/sonde")
	public ResponseEntity<?> showSonde(@PathVariable Long id) {
		List<Sonda> list = SVC.showSonde(id);
		ResponseEntity<List<Sonda>> resp = new ResponseEntity<List<Sonda>>(list, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/{id}/segnali")
	public ResponseEntity<?> showSegnali(@PathVariable Long id) {
		List<Segnale> list = SVC.showSegnali(id);
		ResponseEntity<List<Segnale>> resp = new ResponseEntity<List<Segnale>>(list, HttpStatus.OK);
		return resp;
	}
	
	// POST API METHODS
	@PostMapping
	public ResponseEntity<?> addCentro() {
		Centro c = SVC.addCentro();
		return new ResponseEntity<Centro>(c, HttpStatus.CREATED);
	}
}
