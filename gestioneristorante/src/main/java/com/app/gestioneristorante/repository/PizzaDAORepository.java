package com.app.gestioneristorante.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.gestioneristorante.model.Pizza;

public interface PizzaDAORepository extends CrudRepository<Pizza, Long> {

}
