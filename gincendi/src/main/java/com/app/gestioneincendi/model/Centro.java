package com.app.gestioneincendi.model;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("deprecation")

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "centri")
public class Centro {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany
	private List<Sonda> sonde;
	
	@ManyToMany
	private List<Segnale> segnalazioni;
}
