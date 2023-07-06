package com.esercizio.stream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class OrderList {
	
	private List<Order> List;
	
	public OrderList() {
		List = new ArrayList<Order>();
	}
	
	public void addOrder(String status, LocalDate orderDate, LocalDate deliveryDate, ProductList products, Customer costumer) {
		List.add(new Order(status, orderDate, deliveryDate, products, costumer));
	}
	public void printOrders() {
		for(int i=0; i<List.size(); i++) {
			System.out.println();
			System.out.println("Order: " + List.get(i).id + " Customer: " + List.get(i).costumer.name);
			System.out.println();
			List.get(i).products.printProducts();
		}
		
	}
	public Stream<Order> stream() {
        return List.stream();
    }

	
	
}
