package com.app.gestioneincendi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.gestioneincendi.model.Segnale;
import com.app.gestioneincendi.model.Sonda;
import com.app.gestioneincendi.services.SegnaleService;

@RestController
@RequestMapping("/api/segnali")
public class SegnaleController {

	@Autowired SegnaleService SVC;
	
	// GET API METHODS
	@GetMapping
	public ResponseEntity<List<Segnale>> findAll() {
		List<Segnale> list = SVC.findAll();
		ResponseEntity<List<Segnale>> resp = new ResponseEntity<List<Segnale>>(list, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Segnale s = SVC.findById(id);
		ResponseEntity<Segnale> resp = new ResponseEntity<Segnale>(s, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/sonda")
	public ResponseEntity<?> findBySonda(@RequestBody Sonda sonda) {
		List<Segnale> list = SVC.findBySonda(sonda);
		ResponseEntity<List<Segnale>> resp = new ResponseEntity<List<Segnale>>(list, HttpStatus.OK);
		return resp;
	}
}
