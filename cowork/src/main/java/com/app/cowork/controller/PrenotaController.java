package com.app.cowork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.app.cowork.service.EdificioService;
import com.app.cowork.service.PostazioneService;
import com.app.cowork.service.PrenotazioneService;
import com.app.cowork.service.UtenteService;

@RestController
public class PrenotaController {
	
	@Autowired EdificioService edificioSvc;
	@Autowired PostazioneService postazioneSvc;
	@Autowired PrenotazioneService prenotazioneSvc;
	@Autowired UtenteService utenteSvc;
	
	
}
