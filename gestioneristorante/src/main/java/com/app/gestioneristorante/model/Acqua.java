package com.app.gestioneristorante.model;

import jakarta.persistence.Entity;

@Entity
public class Acqua extends Drink{

	public Acqua() {
		super("Acqua Naturale", 1.00, 0.12);
	}

}
