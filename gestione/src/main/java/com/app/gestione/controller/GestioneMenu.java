package com.app.gestione.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.gestione.classes.Menu;
import com.app.gestione.configurations.MenuConfiguration;

public class GestioneMenu {
	
	AnnotationConfigApplicationContext appContext;
	Menu menu;

	public GestioneMenu() {
		appContext = new AnnotationConfigApplicationContext(MenuConfiguration.class);
		menu = (Menu) appContext.getBean("menu");
	}
	
	public void stampaMenu() {
		System.out.println("##### MENU #####");
		System.out.println("PIZZE: ");
		
		menu.getMenuPizza().forEach(p -> System.out.println(p.getMenuLine()));
		
		System.out.println();
		
		System.out.println("DRINK: ");
		
		menu.getMenuDrink().forEach(d -> System.out.println(d.getMenuLine()));
		
		System.out.println();
		
		System.out.println("##### BUON APPETITO! #####");
		
	}
}
