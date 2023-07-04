package com.esercizio.uno.app;

import java.util.HashMap;
import java.util.Map;

public class Rubrica {
	private Map<String, String> Rubrica;
	
	public Rubrica() {
		Rubrica = new HashMap<String, String>();
	}
	
	public void addContact(String name, String phone) {
		Rubrica.put(name, phone);
	}
	public void removeContact(String name, String phone) {
		Rubrica.remove(name, phone);
	}
	public void printContacts() {
		for(String name: Rubrica.keySet()) {
			String phone = Rubrica.get(name);
			System.out.println("Nome: " + name + " Phone: " + phone);
		}
	}
	public void findContact(String phone) {
		System.out.println( Rubrica.get(phone));
	}
}
