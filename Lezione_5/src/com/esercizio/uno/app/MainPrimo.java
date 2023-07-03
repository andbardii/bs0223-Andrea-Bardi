package com.esercizio.uno.app;

import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPrimo {
	public static Scanner scan = new Scanner(System.in);
	public static Random rand = new Random();
	public static Logger log = LoggerFactory.getLogger(MainPrimo.class);
	
	public static void main(String[] args) {
		int[] randomArray = new int[5];
		programmaArr(randomArray);
	}
	
	public static void programmaArr(int[] arr) {
		for(int i=0; i < arr.length; i++) {
			arr[i] = rand.nextInt(10)+1;
		}
		printData(arr);
		int y = 0;
		do {
			
			log.info("Inserisci la posizione da 1 a 5: ");
			int pos = scan.nextInt();
			if(pos == 0) {
				y++;
			}
			log.info("Inserisci il nuovo numero da 1 a 10: ");
			int newNum = scan.nextInt();
			if(newNum > 10 || newNum < 1) {
				log.error("Numero fuori dal range permesso");
				y++;
			}
			
			try {
			arr[pos-1] = newNum;
			}catch(ArrayIndexOutOfBoundsException e) {
				log.error("Posizione nel array inesistente");
			};
			printData(arr);
			
			
		}while(y != 1);
	}
	public static void printData(int[] arr) {
		  StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < arr.length; i++) {
	            sb.append(arr[i]).append(" ");
	        }
	        log.info("Array: " + sb.toString());
	}
}
