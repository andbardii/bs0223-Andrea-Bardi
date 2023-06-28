package esercizio3;

import java.util.Scanner;

public class MainZone {

	public static void main(String[] args) {
		
		divideChar();

	}
	
	public static void divideChar() {
		
		

		Scanner scan = new Scanner(System.in);
		System.out.print("Inserisci il testo: ");
		String string = scan.next();
		
		
		do {
			System.out.print("Inserisci il testo: ");
			string = scan.next();
			
			int l = string.length();
			
			
			char[] charArray = new char[l];
			
			for (int i = 0; i < string.length(); i++) {
				
	            charArray[i] = string.charAt(i);
	            
	        }
			
			for(int j = 0; j < charArray.length; j++) {
				
				System.out.println(charArray[j]);
				
			}
			
		}
		while(!string.equals(":d"));
			
	}

}
