package com.app.gestioneincendi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.gestioneincendi.model.Segnale;

public interface SegnaliRepository  extends JpaRepository<Segnale, Long>{

}
