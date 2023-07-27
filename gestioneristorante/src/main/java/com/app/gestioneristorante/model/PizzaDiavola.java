package com.app.gestioneristorante.model;

import jakarta.persistence.Entity;

@Entity
public class PizzaDiavola extends Pizza{

	public PizzaDiavola() {
		super("Pizza Diavola", 6.50, "(salame - peperoncino - pomodoro - mozzarella)", 1093.13);
	}

}
