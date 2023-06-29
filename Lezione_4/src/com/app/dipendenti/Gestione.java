package com.app.dipendenti;

public class Gestione {

	public static void main(String[] args) {
		
		Dipendente Mario = new Dipendente("#HAFI77563GHA", Livello.DIRIGENTE, Dipartimento.AMMINISTRAZIONE);
		Mario.stampaDatiDipendendente();
		Mario.promuovi();
		
		Dipendente.calcolaPaga(Mario);
		Dipendente.calcolaPaga(Mario, 10);
		
		Dipendente Francesco = new Dipendente("#EHFOCJSU683K", Livello.OPERAIO, Dipartimento.PRODUZIONE);
		Francesco.promuovi();
		Francesco.stampaDatiDipendendente();
		
		Dipendente Alessia = new Dipendente("#AAHFLS763658", Livello.QUADRO, Dipartimento.VENDITE);
		Alessia.stampaDatiDipendendente();
		
		Dipendente Gianna = new Dipendente("#9HFKSJK53HDI", Livello.IMPIEGATO, Dipartimento.PRODUZIONE);
		Dipendente.calcolaPaga(Gianna, 12.50);
		Gianna.stampaDatiDipendendente();
		printAllStipendi(Mario, Francesco, Alessia, Gianna);

	}
	
	public static void printAllStipendi(Dipendente d1, Dipendente d2, Dipendente d3, Dipendente d4) {
		double s1 = Dipendente.calcolaPaga(d1, 5);
		double s2 = Dipendente.calcolaPaga(d2, 5);
		double s3 = Dipendente.calcolaPaga(d3, 5);
		double s4 = Dipendente.calcolaPaga(d4, 5);
		
		double total = s1 + s2 + s3 + s4;
		
		System.out.println("Il totale degli stipendi è: " + total + "$");
	}

}
