package com.app.gestioneristorante.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Menu {

	private List<Product> menu = new ArrayList<Product>();
	
}
