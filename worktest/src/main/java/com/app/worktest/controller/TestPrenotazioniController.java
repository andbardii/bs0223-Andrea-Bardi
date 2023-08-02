package com.app.worktest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.worktest.model.Prenotazione;

@RestController
@RequestMapping("/test")
public class TestPrenotazioniController {
	
	@GetMapping
	public ResponseEntity<String> getTest() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Author", "Marione");
		
		ResponseEntity<String> resp;
		if(true) {
			resp = new ResponseEntity<String>("getTest", headers, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("Errore!!!!", headers, HttpStatus.NOT_FOUND);
		}
		return resp;
	}
	
	@GetMapping("/{id}")
	public String getTestByID() {
		return "getTestByID";
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String postTest(@RequestBody Prenotazione obj) {
		System.out.println(obj);
		return "postTest";
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public String putTest() {
		return "putTest";
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String deleteTest() {
		return "deleteTest";
	}

}
