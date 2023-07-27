package com.app.gestione.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.gestione.controller.GestioneMenu;

@Component
public class MenuRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		GestioneMenu menu = new GestioneMenu();
	}

}
