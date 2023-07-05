package com.esercizio.tre;

import java.io.IOException;

public class MainTre {

	public static void main(String[] args) throws IOException {
	
		RegistroPresenze Registro = new RegistroPresenze();
		
		Dipendente Andrea = new Dipendente("Andrea");
		// INIZIO ZONA GESTIONE DIPENDENTE
		Andrea.addPresenze(10);
		// FINE 
		Registro.addDipendente(Andrea);
		
		Dipendente Federico = new Dipendente("Federico");
		Federico.addPresenze(4);
		Federico.addPresenze(5);
		Registro.addDipendente(Federico);
		
		Dipendente Gianluca = new Dipendente("Gianluca");
		Gianluca.addPresenze(30);
		Registro.addDipendente(Gianluca);
		
		Dipendente Alessia = new Dipendente("Alessia");
		Alessia.addPresenze(14);
		Registro.addDipendente(Alessia);
		
		// INIZIO ZONA GESTIONE MAP DIPENDENTI E FILE DIPENDENTI
		Registro.getAndSaveDipendenti();
		// FINE 
		
		// INIZIO ZONA GESTIONE DIPENDENTI LOCALI
		Registro.toggleLocalUsers();
		// FINE
	}

}
