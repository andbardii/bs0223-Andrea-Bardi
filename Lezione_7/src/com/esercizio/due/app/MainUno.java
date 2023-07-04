package com.esercizio.due.app;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainUno {
	
	public static Logger log = LoggerFactory.getLogger(MainUno.class);
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		toggleStrings();

	}
	
	public static void toggleStrings() {
		
		Set<String> stringSet = new HashSet<String>();
		Set<String> duplicatedList = new HashSet<String>();
		
		log.info("Insersici il numero di parole: ");
		int len = Integer.parseInt(scan.nextLine());
		
		for(int i = 0; i < len; i++) {
			
			log.info("Insersici parola: ");
			String parola = scan.nextLine();
			
			if(!stringSet.add(parola)) {
				duplicatedList.add(parola);
			}else {
				stringSet.add(parola);
			}
			
			
		}
		printDuplicated(duplicatedList);
		printUnique(stringSet);
		
		
	}

	private static void printUnique(Set<String> set) {
		
		log.info( set.size() + " Parole uninche: ");
		
		Object[] arr = set.toArray();
		for (Object par : arr) {
			log.info("Parola: " + par.toString());
		}
		
	}

	private static void printDuplicated(Set<String> set) {
		
		if(set.isEmpty()) {
			log.info("Ottimo, non ci sono parole duplicate!");
		}else {
			log.info("Parole duplicate: ");
			Object[] arr = set.toArray();
			for (Object par : arr) {
				log.info("Parola: " + par.toString());
			}
			
		}
	}
}
