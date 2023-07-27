package com.app.gestione.classes;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ordine {
	
	private Integer numeroOrdine;
	private StatoOrdine statoOrdine;
	private Integer numeroCoperti;
	private LocalTime oraAcquisizioneOrdine;
	private Double costoCoperto;
	private Map<Product, Integer> ordinato = new HashMap<Product, Integer>();
	
	public void addMeunuItem(Product item) {
		if(!ordinato.containsKey(item)) {
			ordinato.put(item, 1);
		} else {
			ordinato.put(item, ordinato.get(item)+1);
		}
		System.out.println("Prodotto aggiunto al tuo ordine!!");
	}
	
	public void removeMeunuItem(Product item) {
		if(ordinato.containsKey(item)) {
			if(ordinato.get(item) == 1) {
				ordinato.remove(item);
			} else {
				ordinato.put(item, ordinato.get(item)-1);
			}
		} 
		System.out.println("Prodotto rimosso dal tuo ordine!!");
	}
	
	public void getTotale() {
		Double totale = 0.0;
		for (Product item : ordinato.keySet()) {
			totale += item.getPrice() * ordinato.get(item);
		}
		
		totale += (costoCoperto * numeroCoperti) ;
		
		System.out.println("Il totale del tuo ordine è " + totale);
	}

}
