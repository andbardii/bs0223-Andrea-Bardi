package com.app.worktest.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.worktest.model.Utente;

public interface UtenteDAO extends CrudRepository<Utente, Long>  {
	
	public boolean existsById(Long id);
	public boolean existsByEmail(String email);

}
