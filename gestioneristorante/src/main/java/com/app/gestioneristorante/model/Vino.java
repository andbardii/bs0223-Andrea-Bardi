package com.app.gestioneristorante.model;

import jakarta.persistence.Entity;

@Entity
public class Vino extends Drink{

	public Vino() {
		super("Vino Rosso", 9.99, 129.34);
	}

}
