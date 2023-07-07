package com.main.app;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.classes.app.Author;
import com.enums.app.Country;
import com.enums.app.Periodicity;
import com.enums.app.Type;
import com.lists.app.PrintableList;

public class Main {

	public static Logger log = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		
		Author Orwell = new Author(245333684, "George Orwell", Country.ENGLAND);
		Author Pirandello = new Author(642875824, "Luigi Pirandello", Country.ITALY);
		Author Marquez = new Author(347838723,"Gabriel Garca Marquez", Country.COLOMBIA);
		
//		AGGIUNGI ELEMENTI
		PrintableList Catalog = new PrintableList();
		Catalog.addBook(581264947, "Animal Farm", 257, Orwell, Type.DISTOPIC, LocalDate.of(1945, 8, 17));
		Catalog.addBook(588367903, "La mala hora", 261, Marquez, Type.NOVEL, LocalDate.of(1966, 10, 12));
		Catalog.addBook(722506844, "Il fu Mattia Pascal", 340, Pirandello, Type.NOVEL, LocalDate.of(1904, 1, 24));
		Catalog.addMagazine(455149549, "FRIGIDAIRE", 30, Periodicity.MONTHLY, LocalDate.of(2000, 1, 10));
		
//		STAMPA TUTTI GLI ELEMENTI
//		Catalog.printAllPrintable();
		
//		RIMUOVI ELEMENTI
//		Catalog.deletebyISBN(581264947);
		
//		CERCA ELEMENTI PER ISBN
//		Catalog.findByISBN(581264947);
		
//		Catalog.printAllPrintable();
		
//		CERCA ELEMENTI PER ANNO
//		Catalog.findByYear(1945);
		
//		CERCA ELEMENTI PER AUTORE
//		Catalog.findByAuthor(Orwell);
		
//		
		
	}

}
