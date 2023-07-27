package com.app.gestioneristorante.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.gestioneristorante.model.Drink;
import com.app.gestioneristorante.model.Menu;
import com.app.gestioneristorante.model.Merch;
import com.app.gestioneristorante.model.Pizza;

public class MenuController {

	AnnotationConfigApplicationContext appContext;
	Menu menu;

	public MenuController() {
		appContext = new AnnotationConfigApplicationContext(MenuController.class);
		menu = (Menu) appContext.getBean("menu");
	}
	
	public void stampaMenu() {
		System.out.println("##### INIZIO MENU #####");
		System.out.println();
		
		System.out.println("PIZZE");
		menu.getMenu().forEach(p -> {
			if(p instanceof Pizza) {
				p = (Pizza)p;
				System.out.println(p.toString());
			}
		});
		
		System.out.println();
		
		System.out.println("DRINK");
		menu.getMenu().forEach(d -> {
			if(d instanceof Drink) {
				d = (Drink)d;
				System.out.println(d.toString());
			}
		});
		
		System.out.println();
		
		System.out.println("MERCH UFFCIALE");
		menu.getMenu().forEach(m -> {
			if(m instanceof Merch) {
				m = (Merch)m;
				System.out.println(m.toString());
			}
		});
		
		System.out.println();
		
		System.out.println("***** FINE *****");
		
		
		
		
		
	}
}
