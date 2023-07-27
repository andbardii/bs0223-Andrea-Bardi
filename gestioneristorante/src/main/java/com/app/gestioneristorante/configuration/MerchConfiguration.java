package com.app.gestioneristorante.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.app.gestioneristorante.model.Merch;

@Configuration
@PropertySource("classpath:application.properties")
public class MerchConfiguration {

	@Bean("magliettaRistorante")
	@Scope("prototype")
	public Merch magliettaRistorante() {
		return new Merch();
	}
	
	@Bean("tazzaRistorante")
	@Scope("prototype")
	public Merch tazzaRistorante() {
		return new Merch();
	}
	
	@Bean("calziniRistorante")
	@Scope("prototype")
	public Merch calziniRistorante() {
		return new Merch();
	}
	
}
