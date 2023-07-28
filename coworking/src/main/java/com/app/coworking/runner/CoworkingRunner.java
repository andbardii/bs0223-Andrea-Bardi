package com.app.coworking.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.coworking.model.TipoPostazione;
import com.app.coworking.service.EdificioService;
import com.app.coworking.service.PostazioneService;
import com.app.coworking.service.PrenotazioneService;
import com.app.coworking.service.UtenteService;

@Component
public class CoworkingRunner implements CommandLineRunner {

	@Autowired EdificioService edificioSvc;
	@Autowired PostazioneService postazioneSvc;
	@Autowired PrenotazioneService prenotazioneSvc;
	@Autowired UtenteService utenteSvc;
	
	@Override
	public void run(String... args) throws Exception {
		edificioSvc.creaEdificio("Atabaliba Studio", "via Alserio 23", "Milano");
//		postazioneSvc.creaPostazione("Sala riunioni rooftop", TipoPostazione.SALARIUNIONI, 100,  );
	}

}
