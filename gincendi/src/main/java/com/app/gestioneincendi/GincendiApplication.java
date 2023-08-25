package com.app.gestioneincendi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GincendiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GincendiApplication.class, args);
	}

}
