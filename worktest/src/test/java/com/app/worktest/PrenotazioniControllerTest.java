package com.app.worktest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.app.worktest.model.Prenotazione;
import com.app.worktest.repository.PrenotazioneDAO;
import com.app.worktest.service.PostazioneService;
import com.app.worktest.service.UtenteService;


@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class PrenotazioniControllerTest {
	
	private Logger log = LoggerFactory.getLogger(PrenotazioniControllerTest.class);
	
	@Autowired TestRestTemplate restTemplate;
	@Autowired UtenteService utenteSvc;
	@Autowired PostazioneService postazioneSvc;
	@Autowired PrenotazioneDAO prenotazioneDAO;
	@Autowired @Qualifier("prenotazione") ObjectProvider<Prenotazione> prenotazioniTest;

	@Test
	@DisplayName("CERCO UNA PRENOTAZIONE TRAMITE ID CON SUCCESSO")
	void testSuccessGetByID() {
		Prenotazione p = prenotazioniTest.getObject();
		p.setData(LocalDate.of(2024, 1, 1));
		p.setUtente(utenteSvc.findById(1));
		p.setPostazione(postazioneSvc.findById(1));
		prenotazioneDAO.save(p);
		
		log.info(p.toString());
		
		String url = "http://localhost:8080/prenotazione/" + p.getId();
		ResponseEntity<Prenotazione> resp = restTemplate.getForEntity(url, Prenotazione.class);
		
		Prenotazione testPrenotazione = resp.getBody();
		HttpStatusCode code = resp.getStatusCode();
		
		log.info(testPrenotazione.toString());
		log.info(code.toString());
		
		assertThat(code).isEqualTo(HttpStatus.OK);
		assertThat(testPrenotazione.getId()).isEqualTo(p.getId());
	}
	
	@Test
	@DisplayName("CERCO UNA PRENOTAZIONE TRAMITE ID SBAGLIANDO")
	void testNotFoundGetByID() {
				
		String url = "http://localhost:8080/prenotazione/100" ;
		ResponseEntity<String> resp = restTemplate.getForEntity(url, String.class);
		
		String testError = resp.getBody();
		HttpStatusCode code = resp.getStatusCode();
		
		log.info(testError);
		log.info(code.toString());
		
		assertThat(code).isEqualTo(HttpStatus.NOT_FOUND);
		
	}

	@Test
	@Disabled
	void testCreatePrenotazione() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testUpdatePrenotazione() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testRemovePrenotazione() {
		fail("Not yet implemented");
	}

}


