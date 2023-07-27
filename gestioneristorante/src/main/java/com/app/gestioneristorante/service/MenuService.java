package com.app.gestioneristorante.service;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.gestioneristorante.model.Drink;
import com.app.gestioneristorante.model.Menu;
import com.app.gestioneristorante.model.Merch;
import com.app.gestioneristorante.model.Pizza;
import com.app.gestioneristorante.model.Product;
import com.app.gestioneristorante.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired MenuRepository menuRepo;
	@Autowired @Qualifier("menu") private ObjectProvider<Menu> menuProvider;
	
	public void createProduct() {
		menuProvider.getObject()
			.getMenu().forEach(p -> {
				menuRepo.save(p);
			});
	}
	
	public void stampaMenu() {
		System.out.println("##### INIZIO MENU #####");
		System.out.println();
		
		System.out.println("PIZZE");
		menuProvider.getObject().getMenu().forEach(p -> {
			if(p instanceof Pizza) {
				p = (Pizza)p;
				System.out.println(p.toString());
			}
		});
		
		System.out.println();
		
		System.out.println("DRINKS");
		menuProvider.getObject().getMenu().forEach(d -> {
			if(d instanceof Drink) {
				d = (Drink)d;
				System.out.println(d.toString());
			}
		});
		
		System.out.println();
		
		System.out.println("MERCH UFFICIALE");
		menuProvider.getObject().getMenu().forEach(m -> {
			if(m instanceof Merch) {
				m = (Merch)m;
				System.out.println(m.toString());
			}
		});
		
		System.out.println();
		System.out.println("##### FINE #####");
		
	}
	
	public void findAll() {
		menuRepo.findAll().forEach(o -> System.out.println(o));
	}

	public Product findById(long id) {
		return menuRepo.findById(id).get();
	}

	public void updateFoodItem(Product p) {
		menuRepo.save(p);
	}
	
	public void removeFoodItem(Product p) {
		menuRepo.delete(p);
	}
	
}
