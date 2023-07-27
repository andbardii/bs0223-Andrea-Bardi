package com.app.gestioneristorante.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.gestioneristorante.model.Drink;
import com.app.gestioneristorante.repository.DrinkDAORepository;

@Service
public class DrinkService {

	@Autowired DrinkDAORepository drinkRepo;
	
	@Autowired @Qualifier("drinkAcquaBean") private ObjectProvider<Drink> drinkAcquaBeanProvider;
	@Autowired @Qualifier("drinkVinoBean") private ObjectProvider<Drink> drinkVinoProvider;
	@Autowired @Qualifier("drinkLimonataBean") private ObjectProvider<Drink> drinkLimonataProvider;
	
	public Drink createDrinkAcqua() {
		return drinkAcquaBeanProvider.getObject();
	}

	public Drink createDrinkVino() {
		return drinkVinoProvider.getObject();
	}
	
	public Drink createDrinkLimonata() {
		return drinkLimonataProvider.getObject();
	}
	
	// JPA METHODS
	
		public void createDrink(Drink d) {
			drinkRepo.save(d);
			System.out.println(d.getName() + " " + d.getPrice() + " SAVED CORRECTLY");
		}
		
		public void updateDrink(Drink d) {
			drinkRepo.save(d);
			System.out.println(d.getName() + " " + d.getPrice() + " EDITED CORRECTLY");
		}
		
		public void removeDrink(Drink d) {
			drinkRepo.delete(d);
			System.out.println(d.getName() + " " + d.getPrice() + " DELETED CORRECTLY");
		}
		
		public Drink findDrink(long id) {
			return drinkRepo.findById(id).get();
		}
		
		public List<Drink> findAllDrink() {
			return (List<Drink>) drinkRepo.findAll();
		}
		
}
