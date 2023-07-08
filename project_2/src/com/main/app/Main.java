package com.main.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.classes.app.Author;
import com.enums.app.Country;
//import com.enums.app.Periodicity;
//import com.enums.app.Type;
import com.lists.app.PrintableList;

public class Main {

	public static Logger log = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		
		Author Orwell = new Author(245333684, "George Orwell", Country.ENGLAND);
//		Author Pirandello = new Author(642875824, "Luigi Pirandello", Country.ITALY);
//		Author Marquez = new Author(347838723,"Gabriel Garca Marquez", Country.COLOMBIA);
		
//		AGGIUNGI ELEMENTI
		PrintableList Catalog = new PrintableList();
//		Catalog.addBook("B581264947", "Animal Farm", 257, Orwell, Type.DISTOPIC, 1945);
//		Catalog.addBook("B588367903", "La mala hora", 261, Marquez, Type.NOVEL, 1966);
//		Catalog.addBook("B722506844", "Il fu Mattia Pascal", 340, Pirandello, Type.NOVEL, 1904);
//		Catalog.addMagazine("M455149549", "FRIGIDAIRE", 30, Periodicity.MONTHLY, 2000);
		
//		STAMPA TUTTI GLI ELEMENTI
//		Catalog.printAllPrintable();
		
//		RIMUOVI ELEMENTI
//		Catalog.deleteByISBN("B581264947");
		
//		CERCA ELEMENTI PER ISBN
//		Catalog.findByISBN("M455149549");
		
//		Catalog.printAllPrintable();
		
//		CERCA ELEMENTI PER ANNO
//		Catalog.findByYear(1945);
		
//		CERCA ELEMENTI PER AUTORE
//		Catalog.findByAuthor(Orwell);
		
		Catalog.restoreFromFile();
//		Catalog.printAllPrintable();
		Catalog.findByAuthor(Orwell);
//		Catalog.findByISBN("M455149549");
//		Catalog.deleteByISBN("B581264947");
		Catalog.findByYear(1945);
	}

}
