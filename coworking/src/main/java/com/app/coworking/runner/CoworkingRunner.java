package com.app.coworking.runner;

import java.time.LocalDate;

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
//		##### CREA EDIFICI #####
		edificioSvc.creaEdificio("Atabaliba Studio", "via Alserio 23", "Milano");
		edificioSvc.creaEdificio("Regus", "via del Monte 1", "Bologna");
		edificioSvc.creaEdificio("Silos 93", "via Chambery 93", "Torino");
		
//		##### CREA POSTAZIONI #####
		postazioneSvc.creaPostazione("Sala riunioni principale", TipoPostazione.SALARIUNIONI, 100, 1);
		postazioneSvc.creaPostazione("Sala riunioni principale", TipoPostazione.SALARIUNIONI, 150, 2);
		postazioneSvc.creaPostazione("Sala riunioni principale", TipoPostazione.SALARIUNIONI, 50, 3);
		
		postazioneSvc.creaPostazione("Spazio comune", TipoPostazione.OPENSPACE, 40, 3);
		postazioneSvc.creaPostazione("Sala generale", TipoPostazione.OPENSPACE, 30, 2);
		postazioneSvc.creaPostazione("Spazio aperto", TipoPostazione.OPENSPACE, 50, 1);
		
		postazioneSvc.creaPostazione("Sala Blu", TipoPostazione.PRIVATO, 5, 1);
		postazioneSvc.creaPostazione("Sala Verde", TipoPostazione.PRIVATO, 5, 1);
		postazioneSvc.creaPostazione("Sala Rossa", TipoPostazione.PRIVATO, 5, 1);
		postazioneSvc.creaPostazione("Sala Privata", TipoPostazione.PRIVATO, 3, 2);
		postazioneSvc.creaPostazione("Sala Privata", TipoPostazione.PRIVATO, 7, 3);
		postazioneSvc.creaPostazione("Sala Privata Grande", TipoPostazione.PRIVATO, 10, 3);

//		##### CREA UTENTI #####
		utenteSvc.creaUtente("Andrea Bardi", "@andbardii","andbardii@icloud.com");
		utenteSvc.creaUtente("Federico Morgante", "@fedemorgante","federicomorgante@gmail.com");
		utenteSvc.creaUtente("Vincenzo Schembri", "@vinceee","vincenzoschembri@gmail.com");
		utenteSvc.creaUtente("Gianluca Falcone", "@gianlucone","gianlucafalcone@gmail.com");

//		##### CREA PRENOTAZIONI #####
		prenotazioneSvc.creaPrenotazione(10, 1, LocalDate.of(2023, 8, 1));
		prenotazioneSvc.creaPrenotazione(10, 3, LocalDate.of(2023, 8, 1));
		prenotazioneSvc.creaPrenotazione(10, 2, LocalDate.of(2023, 8, 1));
		prenotazioneSvc.creaPrenotazione(10, 4, LocalDate.of(2023, 8, 1));
		prenotazioneSvc.creaPrenotazione(9, 2, LocalDate.of(2023, 8, 2));
		prenotazioneSvc.creaPrenotazione(2, 2, LocalDate.of(2023, 8, 2));

//		##### TEST METODI #####
		postazioneSvc.findByTipoAndCitta(TipoPostazione.PRIVATO, "Milano");

		
	}

}
