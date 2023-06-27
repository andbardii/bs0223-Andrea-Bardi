package it.epicode.be;

import java.util.Scanner;
import java.util.Arrays;

public class Helloworld {
	
	

public static void main (String[] args) {
	
		// Print in console
		System.out.println("This is my first Epicode Java Project!");
		
		// First method
		System.out.println(somma());
		
		// Second method
		System.out.println(concatena());
		
		// Second method
		String[] startArr = {"Mele", "Pomeriggio", "Animali", "HTML", "Java"};
		System.out.println(inserisci(startArr));

		}

	// First method
	public static int somma(){
		// Declare Scanner
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Inserisci il primo numero: ");
		int firstNumber = scan.nextInt();
		
		System.out.print("Inserisci il secondo numero: ");
		int secondNumber = scan.nextInt();
		
		int result = firstNumber * secondNumber;
		
		return result;
	}
	// Second method
	public static String concatena(){
		// Declare Scanner
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Inserisci il tuo nome: ");
		String name = scan.nextLine();
		
		System.out.print("Inserisci la tua età: ");
		int age = scan.nextInt();
		
		String result = "Ciao" +" "+ name + " "+ "hai"+" "+ + age +" "+ "anni!";
		
		return result;
	}
	// Third method
		public static String inserisci(String[] x){
			
			// Declare Scanner
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Array Precedente: " + Arrays.toString(x));
			System.out.println("Inserisci il nuovo Elemento: ");
			String newPiece = scan.nextLine();
			
			// Declare new array
		    String[] result = new String[x.length + 1];

		    // Copy old data
		    for (int i = 0; i < x.length; i++) {
		        result[i] = x[i];
		    };
		    
		    result[result.length - 1] = newPiece;
			
		    System.out.println("Array Modificato: ");
		    		
			return Arrays.toString(result);
		}
}



