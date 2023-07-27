package com.app.gestioneristorante.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.app.gestioneristorante.model.Drink;

@Configuration
@PropertySource("classpath:application.properties")
public class DrinkConfiguration {

	@Bean("drinkAcqua")
	@Scope("prototype")
	public Drink drinkAcqua() {
		return new Drink();
	}
	
	@Bean("drinkVino")
	@Scope("prototype")
	public Drink drinkVino() {
		return new Drink();
	}
	
	@Bean("drinkLimonata")
	@Scope("prototype")
	public Drink drinkLimonata() {
		return new Drink();
	}
	
}
