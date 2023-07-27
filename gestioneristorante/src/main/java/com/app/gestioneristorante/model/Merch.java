package com.app.gestioneristorante.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "merch")
public abstract class Merch extends Product{

	public Merch(String name, Double price) {
		super(name, price);
	}
	
}
