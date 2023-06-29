package com.app.dipendenti;

public class Dipendente {

	private double STIPENDIOBASE = 1000.00;
	
	private String matricola;
	private double stipendio;
	private double importoOrarioStraordinario = 12.50;
	private Livello livello;
	private Dipartimento dipartimento;
	
	public Dipendente(String matricola, Dipartimento Dipartimento) {
		
	}

	public Dipendente(	String matricola, 
						Livello livello, 
						Dipartimento dipartimento ) {
		
							super();
							this.matricola = matricola;
							this.livello = livello;
							this.dipartimento = dipartimento;
							this.stipendio = calcolateStipendio(this.STIPENDIOBASE);
	}
	
	public Dipendente(String matricola, double stipendio, double importoOrarioStraordinario, Livello livello, Dipartimento dipartimento) {
		
		super();
		this.matricola = matricola;
		this.stipendio = stipendio;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.livello = livello;
		this.dipartimento = dipartimento;
	}

	private double calcolateStipendio(double sb) {
		
		switch(this.livello) {
		case OPERAIO:
			return sb;
		case IMPIEGATO:
			return sb * 1.2;
		case QUADRO:
			return sb * 1.5;
		case DIRIGENTE:
			return sb * 2;
		default: 
			return sb;
		}
	}
	
 	protected void stampaDatiDipendendente() {
		System.out.println("Matricola N° " + this.matricola);
		System.out.println("Posizione attuale: " + this.livello + " (Dipartimento: " + this.dipartimento + ")");
		System.out.println("Stipendio attuale: " + this.stipendio + " (Stipendio base: " + this.STIPENDIOBASE + "$ )");
	}
	
	protected void promuovi() {

		switch(this.livello) {
		case OPERAIO:
			this.livello = Livello.IMPIEGATO;
			this.stipendio = this.stipendio * 1.2;
			System.out.println("Sei stato promosso a: " + this.livello);
			break;
		case IMPIEGATO:
			this.livello = Livello.QUADRO;
			this.stipendio = this.stipendio * 1.5;
			System.out.println("Sei stato promosso a: " + this.livello);
			break;
		case QUADRO:
			this.livello = Livello.DIRIGENTE;
			this.stipendio = this.stipendio * 2;
			System.out.println("Sei stato promosso a: " + this.livello);
			break;
		case DIRIGENTE:
			System.out.println("SEI GIA UN DIRIGENTE! Puoi pensare di cambiare dipartimento.");
			break;
		}
	}
	
	protected Dipartimento setDipartimento(Dipartimento d) {
		return this.dipartimento = d;
	}
	
	protected double setImportoOratioStraordinario(double d) {
		return this.importoOrarioStraordinario = d;
	}
	
	protected Livello getLivello() {
		return this.livello;
	}
	
	protected String getMatricola() {
		return this.matricola;
	}
	
	protected double getStipendio() {
		return this.stipendio;
	}
	
	protected Dipartimento getDipartimento() {
		return this.dipartimento;
	}
	
	public static void calcolaPaga(Dipendente d) {
		System.out.println("Devi pagare la Matricola N° " + d.matricola + ": " + d.stipendio + "$");
	}
	
	public static double calcolaPaga(Dipendente d, double o) {
		System.out.println("La Matricola N° " + d.matricola + " ha lavorato " + o + " ore di straordinari.");
		double extra = o * d.importoOrarioStraordinario;
		System.out.println("Importo dovuto per gli straordinari: " + extra + "$");
		System.out.println("Importo totale: " + (extra + d.stipendio) + "$");
		
		return extra + d.stipendio;
	}
}
