package com.app.coworking.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.app.coworking.model.Edificio;
import com.app.coworking.model.Postazione;
import com.app.coworking.model.Prenotazione;
import com.app.coworking.model.Utente;

@Configuration
@PropertySource("classpath:application.properties")
public class CoworkingConfiguration {

	@Bean("edificio")
	@Scope("prototype")
	public Edificio edificio() {
		return new Edificio();
	}
	
	@Bean("utente")
	@Scope("prototype")
	public Utente utente() {
		return new Utente();
	}
	
	@Bean("prenotazione")
	@Scope("prototype")
	public Prenotazione prenotazione() {
		return new Prenotazione();
	}
	
	@Bean("postazione")
	@Scope("prototype")
	public Postazione postazione() {
		return new Postazione();
	}
}
