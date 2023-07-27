package com.app.gestioneristorante.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue(value = "drink")
public abstract class Drink extends Product{

	private Double calories;

	public Drink(String name, Double price, Double calories) {
		super(name, price);
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "Drink [calories=" + calories + "]";
	}
	
	
	
}
