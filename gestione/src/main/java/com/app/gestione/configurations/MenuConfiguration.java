package com.app.gestione.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.app.gestione.classes.Acqua;
import com.app.gestione.classes.Limonata;
import com.app.gestione.classes.Menu;
import com.app.gestione.classes.PizzaDiavola;
import com.app.gestione.classes.PizzaHawaii;
import com.app.gestione.classes.PizzaMargherita;
import com.app.gestione.classes.Vino;

@Configuration
public class MenuConfiguration {
	
	@Bean
	@Scope("singleton") 
	public Menu menu() {
		Menu m = new Menu();
		
		m.getMenuPizza().add(pizzaMargherita());
		m.getMenuPizza().add(pizzaHawaii());
		m.getMenuPizza().add(pizzaDiavola());
		
		m.getMenuDrink().add(drinkLimonata());
		m.getMenuDrink().add(drinkAcqua());
		m.getMenuDrink().add(drinkVino());
		
		return m;
	}
	
	// PIZZA BEAN
	
	@Bean
	@Scope("singleton")
	public PizzaMargherita pizzaMargherita() {
		return new PizzaMargherita();
	}
	
	@Bean
	@Scope("singleton")
	public PizzaHawaii pizzaHawaii() {
		return new PizzaHawaii();
	}
	
	@Bean
	@Scope("singleton")
	public PizzaDiavola pizzaDiavola() {
		return new PizzaDiavola();
	}

	// DRINK BEAN
	
	@Bean
	@Scope("singleton")
	public Limonata drinkLimonata() {
		return new Limonata();
	}
	
	@Bean
	@Scope("singleton")
	public Acqua drinkAcqua() {
		return new Acqua();
	}
	
	@Bean
	@Scope("singleton")
	public Vino drinkVino() {
		return new Vino();
	}
}