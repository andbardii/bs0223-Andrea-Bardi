package com.app.cowork.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.cowork.model.Utente;

public interface UtenteDAO extends CrudRepository<Utente, Long>  {

}
