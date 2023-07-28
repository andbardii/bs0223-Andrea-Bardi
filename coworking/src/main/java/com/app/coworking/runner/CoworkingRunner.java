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
		utenteSvc.registraUtente("Andrea Bardi", "@andbardii","andbardii@icloud.com");
		utenteSvc.registraUtente("Federico Morgante", "@fedemorgante","federicomorgante@gmail.com");
		utenteSvc.registraUtente("Vincenzo Schembri", "@vinceee","vincenzoschembri@gmail.com");
		utenteSvc.registraUtente("Gianluca Falcone", "@gianlucone","gianlucafalcone@gmail.com");
		utenteSvc.registraUtente("Mario Rossi", "@mario","mariorossi@gmail.com");

//		##### CREA PRENOTAZIONI #####
		prenotazioneSvc.prenota(10, 1, LocalDate.of(2023, 8, 1));
		prenotazioneSvc.prenota(10, 3, LocalDate.of(2023, 8, 1));
		prenotazioneSvc.prenota(10, 2, LocalDate.of(2023, 8, 1));
		prenotazioneSvc.prenota(10, 4, LocalDate.of(2023, 8, 1));
		prenotazioneSvc.prenota(10, 5, LocalDate.of(2023, 8, 2));
		prenotazioneSvc.prenota(9, 2, LocalDate.of(2023, 8, 2));
		prenotazioneSvc.prenota(2, 2, LocalDate.of(2023, 8, 2));

//		##### TEST METODI #####
		postazioneSvc.findByTipoAndCitta(TipoPostazione.PRIVATO, "Milano");
		prenotazioneSvc.findByUtente(1);
		prenotazioneSvc.changeDataPrenotazione(4, LocalDate.of(2023, 8, 1));
		
	}

}
