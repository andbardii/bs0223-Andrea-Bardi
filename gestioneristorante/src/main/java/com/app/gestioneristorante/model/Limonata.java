package com.app.gestioneristorante.model;

import jakarta.persistence.Entity;

@Entity
public class Limonata extends Drink{

	public Limonata() {
		super("Limonata", 1.99, 15.28);
		
	}

}
