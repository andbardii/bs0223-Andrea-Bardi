package com.app.gestioneristorante.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.app.gestioneristorante.model.Acqua;
import com.app.gestioneristorante.model.Calzini;
import com.app.gestioneristorante.model.Limonata;
import com.app.gestioneristorante.model.Maglietta;
import com.app.gestioneristorante.model.Menu;
import com.app.gestioneristorante.model.PizzaDiavola;
import com.app.gestioneristorante.model.PizzaHawaii;
import com.app.gestioneristorante.model.PizzaMargherita;
import com.app.gestioneristorante.model.Tazza;
import com.app.gestioneristorante.model.Vino;

@Configuration
public class MenuConfiguration {

	@Bean("menu")
	@Scope("singleton") 
	public Menu menu() {
		Menu m = new Menu();
		
		m.getMenu().add(pizzaMargherita());
		m.getMenu().add(pizzaHawaii());
		m.getMenu().add(pizzaDiavola());
		
		m.getMenu().add(drinkLimonata());
		m.getMenu().add(drinkAcqua());
		m.getMenu().add(drinkVino());
		
		m.getMenu().add(merchMaglietta());
		m.getMenu().add(merchTazza());
		m.getMenu().add(merchCalzini());
		
		return m;
	}
	
	// BEAN PIZZA
	
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

		// BEAN DRINK
		
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
		
		// BEAN DRINK
		
		@Bean
		@Scope("singleton")
		public Maglietta merchMaglietta() {
			return new Maglietta();
		}
			
		@Bean
		@Scope("singleton")
		public Tazza merchTazza() {
			return new Tazza();
		}
				
		@Bean
		@Scope("singleton")
		public Calzini merchCalzini() {
			return new Calzini();
		}
}
