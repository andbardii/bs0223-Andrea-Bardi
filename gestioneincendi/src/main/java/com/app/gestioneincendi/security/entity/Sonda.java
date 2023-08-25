package com.app.gestioneincendi.security.entity;

import java.time.LocalDate;
import java.util.Observable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("deprecation")

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "sonde")
public class Sonda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int latitudine;
	private int longitudine;
	private int livellofumo;
	
}
