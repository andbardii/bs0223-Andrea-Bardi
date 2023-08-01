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
		uSvc.salvaUtenteRubrica("Federico Morgante", "ferdicomorgante@gmail.com", 333263783, "https://pbs.twimg.com/media/Fcnl3C0akAEBOPS.jpg");
		uSvc.salvaUtenteRubrica("Gianluca Falcone", "gianlucone@icloud.com", 322377738 , "https://cdn.domestika.org/c_fill,dpr_auto,f_auto,h_256,pg_1,t_base_params,w_256/v1639582542/avatars/008/465/665/8465665-original.png?1639582542");
		uSvc.salvaUtenteRubrica("Vincenzo Schembri", "vincenzoschembri@gmail.com", 368432798, "https://c-cl.cdn.smule.com/rs-s84/arr/b9/c1/d6fe4d23-d5ce-4517-b8ea-cdd37d33f6a6.jpg");
		uSvc.salvaUtenteRubrica("Francesca Michelin", "francescaofficial@gmail.com", 332432422, "https://cdn.icon-icons.com/icons2/11/PNG/256/customer_person_people_woman_user_client_1631.png");
		uSvc.salvaUtenteRubrica("Maria Rossi", "mariarossi@icloud.com", 348755864, "https://cdn.icon-icons.com/icons2/11/PNG/256/customer_person_people_woman_user_client_1631.png");
		uSvc.salvaUtenteRubrica("Roberta Fiori", "robbyfiori@gmail.com", 378565478, "https://cdn.icon-icons.com/icons2/11/PNG/256/customer_person_people_woman_user_client_1631.png");
		
	}
	
	
}
