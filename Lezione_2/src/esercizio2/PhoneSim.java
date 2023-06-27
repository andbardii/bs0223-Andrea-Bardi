package esercizio2;

import java.util.Arrays;

public class PhoneSim {
	
	int phoneNumber;
	double credit = 0;
	int calls = 0;
	CallPhone[] callsNumber = new CallPhone[5];
	
	
	public PhoneSim(int numb) {
		this.phoneNumber = numb;
	}
	
	public void showSim() {
		System.out.println("Il tuo numero di telefono è: " + this.phoneNumber);
		System.out.println("Credito residuo: " + this.credit + "$");
		System.out.println("Hai effettuato " + this.calls + " chiamate.");
	}
	
	public void showCalls() {
		System.out.println("REGISTRO CHIAMATE");
		System.out.println(Arrays.toString(callsNumber));
	}
	
}
