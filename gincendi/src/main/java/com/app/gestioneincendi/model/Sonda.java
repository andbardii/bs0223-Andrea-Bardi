package com.app.gestioneincendi.model;

import java.time.LocalDate;
import java.util.Observable;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.gestioneincendi.services.SegnaleService;
import com.app.gestioneincendi.services.SondaService;

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
