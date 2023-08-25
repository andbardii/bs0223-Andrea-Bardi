package com.app.gestioneincendi.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.app.gestioneincendi.security.entity.Centro;


@Configuration
public class CentriConfig {

	@Bean("centro")
	@Scope("prototype")
	public Centro centro() {
		return new Centro();
	}
}
