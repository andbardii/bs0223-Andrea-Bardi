package esercizio4;

import java.util.Scanner;

public class MainZone {

	public static void main(String[] args) {
		
		getCountDown();

	}
	
	public static void getCountDown() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Inserisci il numero da cui partire: ");
		int number = scan.nextInt();
		
		System.out.println("INIZIO CONTO ALLA ROVESCIA");
		
		for (int n = number; n > 0; n--) {
			System.out.println(n);
		}
		
		System.out.println("MISSILE LANCIATO IN ORBITA");
	}
}
