package com.app.gestioneristorante.model;

import jakarta.persistence.Entity;

@Entity
public class Tazza extends Merch{

	public Tazza() {
		super("Tazza Ufficiale", 9.99);
	}

}
