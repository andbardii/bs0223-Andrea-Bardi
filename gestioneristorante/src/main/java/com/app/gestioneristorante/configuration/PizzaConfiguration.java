package com.app.gestioneristorante.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.app.gestioneristorante.model.Pizza;

@Configuration
@PropertySource("classpath:application.properties")
public class PizzaConfiguration {

	@Bean("pizzaHawaii")
	@Scope("prototype")
	public Pizza pizzaHawaii() {
		return new Pizza();
	}
	
	@Bean("pizzaDiavola")
	@Scope("prototype")
	public Pizza pizzaDiavola() {
		return new Pizza();
	}
	
	@Bean("pizzaMargherita")
	@Scope("prototype")
	public Pizza pizzaMargherita() {
		return new Pizza();
	}
	
}
