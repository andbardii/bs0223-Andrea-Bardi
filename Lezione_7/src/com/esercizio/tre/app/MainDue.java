package com.esercizio.tre.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.esercizio.due.app.MainUno;

public class MainDue {
	
	public static Logger log = LoggerFactory.getLogger(MainDue.class);
	static Scanner scan = new Scanner(System.in);
	public static Random rand = new Random();
	
	public static void main(String[] args) {
		
		toggleNumbers();

	}

	public static void toggleNumbers() {
		
		List<Integer> numberList = new ArrayList<Integer>();
		
		log.info("Inserisci il quantitativo di numeri: ");
		int nuu = Integer.parseInt(scan.nextLine());
		
		for(int i = 0; i < nuu; i++) {
			numberList.add(rand.nextInt(100));
		}
		
		printList(numberList);
		printOrderedList(numberList);
		reversedList(numberList);
		booleanAndList(numberList, true);
		booleanAndList(numberList, false);
	}
	
	private static void printList(List<Integer> list) {
		log.info("Lista iniziale:");
		for(int i=0; i<list.size(); i++) {
			log.info(i + ") " + list.get(i));
		}
		
	}
	
	private static void printOrderedList(List<Integer> list) {
		log.info("Lista ordinata:");
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			log.info(i + ") " + list.get(i));
		}
		
	}

	private static void reversedList(List<Integer> list) {
		log.info("Lista invertita:");
		Collections.sort(list, Collections.reverseOrder());
		for(int i=0; i<list.size(); i++) {
			log.info(i + ") " + list.get(i));
		}
		
	}
	
	private static void booleanAndList(List<Integer> list, boolean b) {
		if(b) {
			log.info("Posizioni pari:");
			 for (int i = 0; i < list.size(); i += 2) {
	                log.info(i + ") " + list.get(i));
	            }
		}else {
			log.info("Posizioni dispari:");
			for (int i = 1; i < list.size(); i += 2) {
                log.info(i + ") " + list.get(i));
            }
		}
		
		
	}
}
