package esercizio2;

import java.util.Scanner;

public class MainZone {

	public static void main(String[] args) {
		
		checkLowValue();

	}
	
	public static void checkLowValue() {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Inserisci il numero: ");
		int number = scan.nextInt();
		
		switch(number) {
		
		case 0:
			System.out.println("Z E R O");
			break;
		case 1:
			System.out.println("U N O");
			break;
		case 2:
			System.out.println("D U E");
			break;
		case 3:
			System.out.println("T R E");
			break;
			
		default:
			System.out.println("E R R O R E");
		}
		
		

	} 

}
