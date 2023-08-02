package com.app.worktest.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.worktest.model.TipoPostazione;
import com.app.worktest.service.EdificioService;
import com.app.worktest.service.PostazioneService;
import com.app.worktest.service.PrenotazioneService;
import com.app.worktest.service.UtenteService;

@Component
public class CoworkingRunner implements CommandLineRunner {

	@Autowired EdificioService edificioSvc;
	@Autowired PostazioneService postazioneSvc;
	@Autowired PrenotazioneService prenotazioneSvc;
	@Autowired UtenteService utenteSvc;
	
	@Override
	public void run(String... args) throws Exception {
		
//		##### CREA EDIFICI #####
		edificioSvc.salvaEdificio("Atabaliba Studio", "via Alserio 23", "Milano");
		edificioSvc.salvaEdificio("Regus", "via del Monte 1", "Bologna");
		edificioSvc.salvaEdificio("Silos 93", "via Chambery 93", "Torino");
		
//		##### CREA POSTAZIONI #####
		postazioneSvc.setPostazione("Sala riunioni principale", TipoPostazione.SALARIUNIONI, 100, 1);
		postazioneSvc.setPostazione("Sala riunioni principale", TipoPostazione.SALARIUNIONI, 150, 2);
		postazioneSvc.setPostazione("Sala riunioni principale", TipoPostazione.SALARIUNIONI, 50, 3);
		
		postazioneSvc.setPostazione("Spazio comune", TipoPostazione.OPENSPACE, 40, 3);
		postazioneSvc.setPostazione("Sala generale", TipoPostazione.OPENSPACE, 30, 2);
		postazioneSvc.setPostazione("Spazio aperto", TipoPostazione.OPENSPACE, 50, 1);
		
		postazioneSvc.setPostazione("Sala Blu", TipoPostazione.PRIVATO, 5, 1);
		postazioneSvc.setPostazione("Sala Verde", TipoPostazione.PRIVATO, 5, 1);
		postazioneSvc.setPostazione("Sala Rossa", TipoPostazione.PRIVATO, 5, 1);
		postazioneSvc.setPostazione("Sala Privata", TipoPostazione.PRIVATO, 3, 2);
		postazioneSvc.setPostazione("Sala Privata", TipoPostazione.PRIVATO, 7, 3);
		postazioneSvc.setPostazione("Sala Privata Grande", TipoPostazione.PRIVATO, 10, 3);

//		##### CREA UTENTI #####
		utenteSvc.registraUtente("Andrea Bardi", "@andbardii","andbardii@icloud.com");
		utenteSvc.registraUtente("Federico Morgante", "@fedemorgante","federicomorgante@gmail.com");
		utenteSvc.registraUtente("Vincenzo Schembri", "@vinceee","vincenzoschembri@gmail.com");
		utenteSvc.registraUtente("Gianluca Falcone", "@gianlucone","gianlucafalcone@gmail.com");
		utenteSvc.registraUtente("Mario Rossi", "@mario","mariorossi@gmail.com");

//		##### CREA PRENOTAZIONI CON(ID POSTAZIONE, ID UTENTE, DATA INTERESSATA) #####
		prenotazioneSvc.prenota(5, 3, LocalDate.of(2023, 8, 1));
		prenotazioneSvc.prenota(4, 2, LocalDate.of(2023, 8, 14));
		prenotazioneSvc.prenota(7, 4, LocalDate.of(2023, 9, 1));
		prenotazioneSvc.prenota(10, 5, LocalDate.of(2023, 8, 2));
		prenotazioneSvc.prenota(9, 2, LocalDate.of(2023, 8, 2));
		prenotazioneSvc.prenota(2, 2, LocalDate.of(2023, 9, 21));
		prenotazioneSvc.prenota(2, 2, LocalDate.of(2023, 8, 3));
		
//		## PRENOTAZIONE DI GRUPPO CON(ID POSTAZIONE, DATA INTERESSATA, ID UTENTI) ##
		prenotazioneSvc.prenotaGruppo(10, LocalDate.of(2023, 8, 27), 1, 2, 3 );
		prenotazioneSvc.prenotaGruppo(1, LocalDate.of(2023, 8, 16), 1, 5, 3 );
		prenotazioneSvc.prenotaGruppo(10, LocalDate.of(2023, 9, 4), 4, 2, 3);

//		## RICERCA POSTAZIONI CON(TIPO POSTAZIONE, CITTA) ##
//		postazioneSvc.findByTipoAndCitta(TipoPostazione.PRIVATO, "Milano");
		
//		## RICERCA PRENOTAZIONI CON(ID UTENTE) ##
//		prenotazioneSvc.findByUtente(1);
		
//		## CAMBIA LA DATA DELLA PRENOTAZIONE CON(ID PRENOTAZIONE, NUOVA DATA)##
//		prenotazioneSvc.changeDataPrenotazione(4, LocalDate.of(2023, 8, 1));
		
//		## CONTROLLA SE E POSSIBILE PRENOTARE CON(ID POSTAZIONE, DATA INTERESSATA) ##
//		prenotazioneSvc.checkDisponibilitaPostazione(10, LocalDate.of(2023, 8, 1));
	}

}
