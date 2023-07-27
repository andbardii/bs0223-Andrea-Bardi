package com.app.gestioneristorante.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.gestioneristorante.model.Drink;

public interface DrinkDAORepository extends CrudRepository<Drink, Long> {

}
