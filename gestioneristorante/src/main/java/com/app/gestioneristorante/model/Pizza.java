package com.app.gestioneristorante.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "pizza")
public abstract class Pizza extends Product{

	private String ingredients;
	private Double calories;
	
	public Pizza(String name, Double price, String ingredients, Double calories) {
		super(name, price);
		this.ingredients = ingredients;
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "Pizza [ingredients=" + ingredients + ", calories=" + calories + "]";
	}
	
	
	
}
