package com.app.gestioneincendi.cofiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.app.gestioneincendi.model.Segnale;
import com.app.gestioneincendi.model.Sonda;

@Configuration
public class SondeConfig {

	@Bean("sonda")
	@Scope("prototype")
	public Sonda sonda() {
		return new Sonda();
	}
	
	@Bean("segnale")
	@Scope("prototype")
	public Segnale segnale() {
		return new Segnale();
	}
	
}
