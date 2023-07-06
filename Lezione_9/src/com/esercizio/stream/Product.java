package com.esercizio.stream;

import java.util.Random;

public class Product {
	
	public static Random rand = new Random();
	
	public long id;
	public String name;
	public String category;
	public double price;
	
	public Product(String name, String category, double price) {
		this.id = rand.nextLong(1000)+rand.nextLong(1000);
		this.name = name;
		this.category = category;
		this.price = price;
	}
	
	
}
