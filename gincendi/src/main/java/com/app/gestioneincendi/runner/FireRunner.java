package com.app.gestioneincendi.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.app.gestioneincendi.services.CentroService;
import com.app.gestioneincendi.services.SegnaleService;
import com.app.gestioneincendi.services.SondaService;

@Component
public class FireRunner implements ApplicationRunner {

	@Autowired SondaService SondaSVC;
	@Autowired SegnaleService SegnaleSVC;
	@Autowired CentroService CentroSVC;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		CentroSVC.addCentro();
		CentroSVC.addCentro();
		
		SondaSVC.addSonda(1, 34, 120);
		SondaSVC.addSonda(1, 11, 68);
		SondaSVC.addSonda(2, 14, 14);
		SondaSVC.addSonda(2, 0, 0);
		
		SondaSVC.random();
	}

}
