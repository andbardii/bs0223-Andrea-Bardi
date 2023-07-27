package com.app.gestioneristorante.model;

import jakarta.persistence.Entity;

@Entity
public class Maglietta extends Merch{

	public Maglietta() {
		super("Maglietta Ufficiale", 29.99);
	}

}
