package com.app.gestioneincendi.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.gestioneincendi.security.entity.Segnale;

public interface SegnaliRepository  extends JpaRepository<Segnale, Long>{

}
