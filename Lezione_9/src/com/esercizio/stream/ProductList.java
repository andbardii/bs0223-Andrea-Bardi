package com.esercizio.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ProductList {

private List<Product> List;
	
	public ProductList() {
		List = new ArrayList<Product>();
	}
	
	public void addNewProduct(String name, String category, double price) {
		List.add(new Product(name, category, price));
	}
	public void addProduct(Product o) {
		List.add(o);
	}
	public Product getProduct(String name) {
		for(int i=0; i<List.size(); i++) {
			Product p = List.get(i);
			if(p.name == name) {
				return p;
			}
		}
		return null;
	}
	public void printProducts() {
		for(int i=0; i<List.size(); i++) {
			System.out.println("Product: " + List.get(i).name);
		}
		
	}
	
	public Stream<Product> stream() {
        return List.stream();
    }

	
}
