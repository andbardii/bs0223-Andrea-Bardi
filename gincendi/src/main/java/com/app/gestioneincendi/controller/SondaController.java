package com.app.gestioneincendi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.gestioneincendi.model.Sonda;
import com.app.gestioneincendi.services.SondaService;

@RestController
@RequestMapping("/api/sonde")
public class SondaController {
	
	@Autowired SondaService SVC;

	// GET API METHODS
	@GetMapping
	public ResponseEntity<List<Sonda>> findAll() {
		List<Sonda> list = SVC.findAll();
		ResponseEntity<List<Sonda>> resp = new ResponseEntity<List<Sonda>>(list, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Sonda s = SVC.findById(id);
		ResponseEntity<Sonda> resp = new ResponseEntity<Sonda>(s, HttpStatus.OK);
		return resp;
	}
	
	// POST API METHODS
	@PostMapping("/{id}/{latitudine}/{longitudine}")
	public ResponseEntity<?> addSonda(@PathVariable long id, @PathVariable int latitudine, @PathVariable int longitudine) {
		Sonda s = SVC.addSonda(id, latitudine, longitudine);
		return new ResponseEntity<Sonda>(s, HttpStatus.CREATED);
	}
	
	// PUT API METHODS
	@PutMapping("/update/{id}/{latitudine}/{longitudine}/{livellofumo}")
	public ResponseEntity<?> update(@PathVariable long id,@PathVariable int latitudine,@PathVariable int longitudine,@PathVariable int livellofumo) {
		Sonda s = SVC.update(id, latitudine, longitudine, livellofumo );
		return new ResponseEntity<Sonda>(s, HttpStatus.OK);
	}
}
