package com.app.gestioneincendi.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.app.gestioneincendi.security.entity.Segnale;
import com.app.gestioneincendi.security.entity.Sonda;

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
