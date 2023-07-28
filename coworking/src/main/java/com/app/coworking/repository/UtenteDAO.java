package com.app.coworking.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.coworking.model.Utente;

public interface UtenteDAO extends CrudRepository<Utente, Long>  {

}
