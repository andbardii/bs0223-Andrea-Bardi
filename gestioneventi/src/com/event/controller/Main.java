package com.event.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import com.event.enums.Sesso;
import com.event.enums.Stato;
import com.event.enums.TipoDiEvento;
import com.event.models.Evento;
import com.event.models.EventoDAO;
import com.event.models.Location;
import com.event.models.Partecipazione;
import com.event.models.Persona;

public class Main {
	public static EventoDAO em = new EventoDAO();

	public static void main(String[] args) {
		
		
		Persona Andrea = new Persona("Andrea", "Bardi", "andbardii@icloud.com", LocalDate.of(2002, 10, 28), Sesso.UOMO, new ArrayList());
		
		Location l1 = new Location("Cirenaica", "Bologna");
		Location l2 = new Location("Piazza Duomo","Milano");
		
		Evento e1 = new Evento("Summit Epicode", LocalDate.of(2023,10,13), "Il summit autunnale di Epicode!", TipoDiEvento.PUBBLICO, 1000, new HashSet(), l1);
		Evento e2 = new Evento("BootCamp Epicode", LocalDate.of(2023,11,27), "BootCamp Java di Epicode.", TipoDiEvento.PRIVATO, 200, new HashSet(), l2);
		
		Partecipazione p1 = new Partecipazione(Andrea, e1, Stato.CONFERMATA);
		
	
//		em.saveEvent(e1);
//		em.saveEvent(e2);
		
		
		
	}

}
