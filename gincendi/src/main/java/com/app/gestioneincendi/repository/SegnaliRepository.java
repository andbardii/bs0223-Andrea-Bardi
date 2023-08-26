package com.app.gestioneincendi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.gestioneincendi.model.Segnale;
import com.app.gestioneincendi.model.Sonda;

public interface SegnaliRepository  extends JpaRepository<Segnale, Long>{

	public List<Segnale> findBySonda(Sonda sonda);
}
