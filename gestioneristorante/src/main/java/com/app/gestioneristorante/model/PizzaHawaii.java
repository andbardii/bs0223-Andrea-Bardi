package com.app.gestioneristorante.model;

import jakarta.persistence.Entity;

@Entity
public class PizzaHawaii extends Pizza{

	public PizzaHawaii() {
		super("Pizza Hawaii", 12.5, "(ananas - prosciutto - pomodoro - mozzarella)", 1264.32);
	}

}
