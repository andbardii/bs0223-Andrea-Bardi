package com.app.gestioneristorante.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.gestioneristorante.model.Pizza;
import com.app.gestioneristorante.repository.PizzaDAORepository;

@Service
public class PizzaService {

	@Autowired PizzaDAORepository pizzaRepo;
	
	@Autowired @Qualifier("pizzaHawaiiBean") private ObjectProvider<Pizza> pizzaHawaiiProvider;
	@Autowired @Qualifier("pizzaDiavolaBean") private ObjectProvider<Pizza> pizzaDiavolaProvider;
	@Autowired @Qualifier("pizzaMargheritaBean") private ObjectProvider<Pizza> pizzaMargheritaProvider;

	public Pizza createPizzaHawaii() {
		return pizzaHawaiiProvider.getObject();
	}

	public Pizza createPizzaDiavola() {
		return pizzaDiavolaProvider.getObject();
	}
	
	public Pizza createPizzaMargherita() {
		return pizzaMargheritaProvider.getObject();
	}
	
	// JPA METHODS
	
			public void createPizza(Pizza p) {
				pizzaRepo.save(p);
				System.out.println(p.getName() + " " + p.getPrice() + " SAVED CORRECTLY");
			}
			
			public void updatePizza(Pizza p) {
				pizzaRepo.save(p);
				System.out.println(p.getName() + " " + p.getPrice() + " EDITED CORRECTLY");
			}
			
			public void removePizza(Pizza p) {
				pizzaRepo.delete(p);
				System.out.println(p.getName() + " " + p.getPrice() + " DELETED CORRECTLY");
			}
			
			public Pizza findPizza(long id) {
				return pizzaRepo.findById(id).get();
			}
			
			public List<Pizza> findAllPizza() {
				return (List<Pizza>) pizzaRepo.findAll();
			}
			
}
