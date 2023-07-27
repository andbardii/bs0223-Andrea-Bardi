package com.app.gestioneristorante.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.gestioneristorante.model.Pizza;
import com.app.gestioneristorante.model.Drink;
import com.app.gestioneristorante.model.Merch;
import com.app.gestioneristorante.service.DrinkService;
import com.app.gestioneristorante.service.MerchService;
import com.app.gestioneristorante.service.PizzaService;

@Component
public class MenuRunner implements CommandLineRunner {

	@Autowired PizzaService pizzaSvc;
	@Autowired DrinkService drinkSvc;
	@Autowired MerchService merchSvc;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("##### MENU RUNNER #####");
		
		Pizza hawaii = pizzaSvc.createPizzaHawaii();
		hawaii.setPrice(12.50);
		hawaii.setName("Pizza Hawaii");
		hawaii.setCalories(1356.69);
		hawaii.setIngredients("(prosciutto - ananas - pomodoro - mozzarella)");
		pizzaSvc.createPizza(hawaii);
		Pizza diavola = pizzaSvc.createPizzaDiavola();
		diavola.setPrice(12.50);
		diavola.setName("Pizza Diavola");
		diavola.setCalories(1056.23);
		diavola.setIngredients("(salame - peperoncino - pomodoro - mozzarella)");
		pizzaSvc.createPizza(diavola);
		Pizza margherita = pizzaSvc.createPizzaMargherita();
		margherita.setPrice(12.50);
		margherita.setName("Pizza Margherita");
		margherita.setCalories(856.69);
		margherita.setIngredients("(pomodoro - mozzarella - basilico)");
		pizzaSvc.createPizza(margherita);
		
		Drink acqua = drinkSvc.createDrinkAcqua();
		acqua.setCalories(0.18);
		acqua.setName("Acqua Naturale");
		acqua.setPrice(1.0);
		drinkSvc.createDrink(acqua);
		Drink vino = drinkSvc.createDrinkVino();
		vino.setCalories(120.96);
		vino.setName("Vino Rosso");
		vino.setPrice(3.99);
		drinkSvc.createDrink(vino);
		Drink limonata = drinkSvc.createDrinkLimonata();
		limonata.setName("Limonata Fresca");
		limonata.setPrice(1.50);
		limonata.setCalories(12.56);
		drinkSvc.createDrink(limonata);
		
		Merch maglietta = merchSvc.createMagliettaRistorante();
		maglietta.setPrice(20.0);
		maglietta.setName("Maglietta Originale");
		merchSvc.createMerch(maglietta);
		Merch tazza = merchSvc.createTazzaRistorante();
		tazza.setPrice(6.50);
		tazza.setName("Tazza Originale");
		merchSvc.createMerch(tazza);
		Merch calzini = merchSvc.createCalziniRistorante();
		calzini.setPrice(12.50);
		calzini.setName("Calzini Originali");
		merchSvc.createMerch(calzini);
	}

}
