package com.esercizio.tre;

public class Dipendente {
	
	public String name;
	private int presenze = 0;
	
	public Dipendente(String n) {
		this.name = n;
	}
	
	public int getPresenze() {
		return presenze;
	}
	public void addPresenze(int i) {
		this.presenze += i;
	}
}
