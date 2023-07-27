package com.app.gestioneristorante.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.gestioneristorante.service.MenuService;


@Component
public class MenuRunner implements CommandLineRunner {

	@Autowired MenuService menu;

	@Override
	public void run(String... args) throws Exception {
		menu.createProduct();
	}

}
