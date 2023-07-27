package com.app.gestioneristorante.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.gestioneristorante.model.Product;

@Repository
public interface MenuRepository extends CrudRepository<Product, Long> {

}
