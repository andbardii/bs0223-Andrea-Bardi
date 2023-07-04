package com.esercizio.uno.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.esercizio.tre.app.MainDue;

public class MainTre {
	
	public static Logger log = LoggerFactory.getLogger(MainDue.class);
	
	public static void main(String[] args) {
	
		Rubrica rub = new Rubrica();
		rub.addContact("Andrea", "345654334");
		rub.printContacts();

	}

}
