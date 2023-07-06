package com.esercizio.stream;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HandleCatalog {
	
	
	public static Logger log = LoggerFactory.getLogger(HandleCatalog.class);
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Customer Andrea = new Customer("Andrea", 3);
		Customer Federico = new Customer("Federico", 2);
		Customer Gianluca = new Customer("Gianluca", 1);
		Customer Alessia = new Customer("Alessia", 2);
		
		ProductList Products = new ProductList();
		
		Products.addNewProduct("IPhone", "Tech", 599.99);
		Products.addNewProduct("MacBook", "Tech", 1999.99);
		Products.addNewProduct("Il Barone Rampante", "Books", 7.69);
		Products.addNewProduct("1984", "Books", 9.99);
		Products.addNewProduct("Vocabolario Italiano", "Books", 140.59);
		Products.addNewProduct("La Divina Commedia", "Books", 30.96);
		Products.addNewProduct("Attaccapanni", "Home", 3.99);
		Products.addNewProduct("Lampadario", "Home", 199.99);
		Products.addNewProduct("Pannolini", "Baby", 5.99);
		Products.addNewProduct("Tovagliette", "Baby", 9.99);
		Products.addNewProduct("Mutande Uomo", "Boy", 2.99);
		Products.addNewProduct("Canottiera Uomo", "Boy", 4.99);
		
//		Products.printProducts();
		
		ProductList AndreaOrdProd = new ProductList();
		AndreaOrdProd.addProduct(Products.getProduct("IPhone"));
		AndreaOrdProd.addProduct(Products.getProduct("MacBook"));
		AndreaOrdProd.addProduct(Products.getProduct("1984"));
		AndreaOrdProd.addProduct(Products.getProduct("Vocabolario Italiano"));
		AndreaOrdProd.addProduct(Products.getProduct("Tovagliette"));
		AndreaOrdProd.addProduct(Products.getProduct("Pannolini"));
		
		ProductList FedericoOrdProd = new ProductList();
		FedericoOrdProd.addProduct(Products.getProduct("MacBook"));
		FedericoOrdProd.addProduct(Products.getProduct("Il Barone Rampante"));
		FedericoOrdProd.addProduct(Products.getProduct("Attaccapanni"));
		FedericoOrdProd.addProduct(Products.getProduct("Tovagliette"));
		
		ProductList GianlucaOrdProd = new ProductList();
		GianlucaOrdProd.addProduct(Products.getProduct("Il Barone Rampante"));
		GianlucaOrdProd.addProduct(Products.getProduct("1984"));
		
		
		OrderList Orders = new OrderList();
		Orders.addOrder("pending", LocalDate.now(), LocalDate.now(), AndreaOrdProd, Andrea);
		Orders.addOrder("pending", LocalDate.now(), LocalDate.now(), FedericoOrdProd, Federico);
		Orders.addOrder("pending", LocalDate.now(), LocalDate.now(), GianlucaOrdProd, Gianluca);
		
//		Orders.printOrders();
	
//		ESERCIZIO 1
		List<Product> cheapBooksStream = Products.stream()
			.filter(p -> p.category == "Books" && p.price <= 100)
			.collect(Collectors.toList());
		System.out.println();
		cheapBooksStream.forEach(p -> log.info("Cheap Book: "+ p.name + " (price: " + p.price + ")" ));
		
//		ESERCIZIO 2
		List<Order> babyNeedsStream = Orders.stream()
				.filter(o -> o.products.stream()
						.anyMatch(p -> p.category.equals("Baby")))
				.collect(Collectors.toList());
		System.out.println();
		System.out.println("Orders with baby stuff:");
		babyNeedsStream.forEach(p -> log.info("Order: "+ p.id + " Customer: " + p.costumer.name));
		
//		ESERCIZIO 3
		List<Product> boysDiscount = Products.stream()
				.filter(p -> p.category == "Boy")
				.map(p ->new Product(p.name, p.category, p.price * 0.9))
				.collect(Collectors.toList());
		System.out.println();
		System.out.println("Boys discounts:");
		boysDiscount.forEach(p -> log.info("Product: "+ p.name + " (price: " + p.price + ")" ));
		
//		ESERCIZIO 4
		List<Customer> Customers = Arrays.asList(Andrea, Federico, Gianluca, Alessia);
		List<Customer> rankedCustomers = Customers.stream()
				.sorted(Comparator.comparing(Customer::getTier))
				.collect(Collectors.toList());
		System.out.println();
		rankedCustomers.forEach(c -> log.info("Customer" + c.name + "(id: " + c.id+ ") Tier: " + c.tier));
	}

}
