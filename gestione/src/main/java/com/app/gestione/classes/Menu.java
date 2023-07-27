package com.app.gestione.classes;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Menu {
	
	private List<PizzaBasic> menuPizza = new ArrayList<PizzaBasic>();
	private List<Drink> menuDrink = new ArrayList<Drink>();

}