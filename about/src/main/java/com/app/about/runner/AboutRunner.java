package com.app.about.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.about.service.UtenteService;

@Component
public class AboutRunner implements CommandLineRunner {

	@Autowired UtenteService uSvc;

	@Override
	public void run(String... args) throws Exception {
//		uSvc.salvaUtenteRubrica("Federico", "ferdicomorgante@gmail.com", 333263783, "https://cdn.domestika.org/c_fill,dpr_auto,f_auto,h_256,pg_1,t_base_params,w_256/v1639582542/avatars/008/465/665/8465665-original.png?1639582542");
//		uSvc.salvaUtenteRubrica("Gianluca", "gianlucone@gmail.com", 322377738 , "https://cdn.domestika.org/c_fill,dpr_auto,f_auto,h_256,pg_1,t_base_params,w_256/v1639582542/avatars/008/465/665/8465665-original.png?1639582542");
//		uSvc.salvaUtenteRubrica("Vincenzo", "vincenzosggg@gmail.com", 333432703, "https://cdn.domestika.org/c_fill,dpr_auto,f_auto,h_256,pg_1,t_base_params,w_256/v1639582542/avatars/008/465/665/8465665-original.png?1639582542");
		
	}
	
	
}
