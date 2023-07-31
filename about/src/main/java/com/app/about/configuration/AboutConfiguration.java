package com.app.about.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.app.about.model.Utente;

@Configuration
@PropertySource("classpath:application.properties")
public class AboutConfiguration {

	@Bean("utente")
	@Scope("prototype")
	public Utente utente() {
		return new Utente();
	}
	
}
