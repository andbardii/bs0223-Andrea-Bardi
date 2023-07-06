package com.esercizio.stream;

import java.time.LocalDate;
import java.util.Random;

public class Order {
	
	public static Random rand = new Random();
	
	public long id;
	public String status;
	public LocalDate orderDate;
	public LocalDate deliveryDate;
	public ProductList products;
	public Customer costumer;
	
	public Order(String status, LocalDate orderDate, LocalDate deliveryDate, ProductList products, Customer costumer) {
		this.id = rand.nextLong(1000)+rand.nextLong(1000);
		this.status = status;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.products = products;
		this.costumer = costumer;
	}
	
	
}
