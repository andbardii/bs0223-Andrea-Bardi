package com.app.gestioneristorante.model;

import jakarta.persistence.Entity;

@Entity
public class Calzini extends Merch{

	public Calzini() {
		super("Calzini Ufficiali", 9.99);
	}

}
