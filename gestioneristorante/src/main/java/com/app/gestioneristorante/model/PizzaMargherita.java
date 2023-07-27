package com.app.gestioneristorante.model;

import jakarta.persistence.Entity;

@Entity
public class PizzaMargherita extends Pizza{

	public PizzaMargherita() {
		super("Pizza Margherita", 5.5, "(pomodoro - mozzarella - basilico)", 820.23);
	}

}
