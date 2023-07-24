package com.app.springfirst.dipendencyinjection;

import java.util.ArrayList;
import java.util.List;

public class TestDependencyInjection {

	public static void main(String[] args) {
		
//		PIZZE
		Pizza margherita = new Pizza(5.00, 898.93, 2.14, 340.54, new ArrayList<Topping>(), Formato.MEDIO, "Pizza Margherita Media");
		
		List<Topping> hawaii_topping = new ArrayList<Topping>();
		hawaii_topping.add(Topping.ANANAS);
		hawaii_topping.add(Topping.PROSCIUTTO_COTTO);
		Pizza hawaii = new Pizza(15.00, 1898.93, 242.14, 40.54, hawaii_topping, Formato.GRANDE, "Pizza Hawaii Grande");
		
		List<Topping> patatine_topping = new ArrayList<Topping>();
		patatine_topping.add(Topping.PATATE_FRITTE);
		patatine_topping.add(Topping.PATATE_AL_FORNO);
		Pizza patatine = new Pizza(7.00, 1598.93, 442.64, 45.27, patatine_topping, Formato.PICCOLO, "Pizza Patatine Piccola");
		
		List<Topping> capperieolive_topping = new ArrayList<Topping>();
		capperieolive_topping.add(Topping.CAPPERI);
		capperieolive_topping.add(Topping.OLIVE);
		Pizza capperieolive = new Pizza(6.00, 558.63, 232.64, 675.27, capperieolive_topping, Formato.MEDIO, "Pizza Capperi e Olive Media");
	
//		DRINK
		Drink acqua = new Drink(1.00, 0.01, 0.01, 0.01, Formato.MEDIO, "Acqua Naturale Media");
		Drink cocacola = new Drink(2.50, 245.56, 245.56, 128.53, Formato.MEDIO, "Coca Cola Media");
		Drink sprite = new Drink(2.50, 145.56, 145.56, 23.53, Formato.MEDIO, "Sprite Media");
		
//		MERCH
		Merch maglietta = new Merch("Maglietta Ufficiale", 35.99);
		Merch tazza = new Merch("Tazza Ufficiale", 4.99);
		Merch calzini = new Merch("Calzini Ufficiali", 3.99);
		Merch portachiavi = new Merch("Portachiavi Ufficiale", 1.99);
		Merch cover = new Merch("Cover Ufficiale", 10.99);
		Merch bicchiere = new Merch("Bicchiere Ufficiale", 6.99);
		
	}

}
