package com.cat.controller;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.cat.daos.PrestitiDAO;
import com.cat.daos.PrintableDAO;
import com.cat.enums.Periodicity;
import com.cat.enums.Type;
import com.cat.models.Book;
import com.cat.models.Magazine;
import com.cat.models.Prestito;
import com.cat.models.Utente;

public class MainCatalogo {

	public static PrintableDAO printDAO = new PrintableDAO();
	public static PrestitiDAO prestDAO = new PrestitiDAO();
	
	public static void main(String[] args) {
		
//		##### BASICS PRINTABLE #####
//		generatePrintable(); 
		
//		printDAO.deleteBook(3);
//		printDAO.getMagazine(2);
//		printDAO.refreshBook(1);
		
//		##### QUERY PRINTABLE #####
//		printDAO.getMagazineByTitle("Focus");
//		printDAO.getBookByAuthor("George Orwell");
//		printDAO.getBookByDate(1948);
		
		
//		##### BASICS PRESTITI #####
//		generateUsers();
//		generatePrestiti();
		
//		prestDAO.getUser(1);
//		prestDAO.getPrestito(3);
//		prestDAO.terminaPrestito(3);
//		prestDAO.deletePrestito(3);
		
//		##### QUERY PRESTITI #####
//		prestDAO.findUsersPresitiBook(1);
//		prestDAO.findUsersPresitiMag(1);
		
//		prestDAO.findDelayPrestitiBook();
//		prestDAO.findDelayPrestitiMag();
		
	}
	public static void generatePrintable(){
		Book b1 = new Book();
		b1.setTitle("Animal Farm");
		b1.setDate(1957);
		b1.setPages(230);
		b1.setAuthor("George Orwell");
		b1.setType(Type.DISTOPIC);
		printDAO.savePrint(b1);
		
		Book b3 = new Book();
		b3.setTitle("1984");
		b3.setDate(1948);
		b3.setPages(290);
		b3.setAuthor("George Orwell");
		b3.setType(Type.DISTOPIC);
		printDAO.savePrint(b3);
		
		Book b4 = new Book();
		b4.setTitle("Perchè odio il mio nome");
		b4.setDate(1948);
		b4.setPages(22);
		b4.setAuthor("Mario Rossi");
		b4.setType(Type.DISTOPIC);
		printDAO.savePrint(b4);

		Book b2 = new Book();
		b2.setTitle("La mala hora");
		b2.setDate(1966);
		b2.setPages(250);
		b2.setAuthor("Gabriel Garcia Marquez");
		b2.setType(Type.NOVEL);
		printDAO.savePrint(b2);
		
		Magazine m1 = new Magazine();
		m1.setTitle("Forbes");
		m1.setDate(2000);
		m1.setPages(30);
		m1.setPeriodicity(Periodicity.WEEKLY);
		printDAO.savePrint(m1);
		
		Magazine m2 = new Magazine();
		m2.setTitle("Frigidaire");
		m2.setDate(1999);
		m2.setPages(41);
		m2.setPeriodicity(Periodicity.BIANNUAL);
		printDAO.savePrint(m2);
		
		Magazine m5 = new Magazine();
		m5.setTitle("Frigidaire");
		m5.setDate(2003);
		m5.setPages(31);
		m5.setPeriodicity(Periodicity.BIANNUAL);
		printDAO.savePrint(m5);
		
		Magazine m3 = new Magazine();
		m3.setTitle("Focus");
		m3.setDate(2010);
		m3.setPages(44);
		m3.setPeriodicity(Periodicity.BIANNUAL);
		printDAO.savePrint(m3);
		
		Magazine m4 = new Magazine();
		m4.setTitle("Focus");
		m4.setDate(2011);
		m4.setPages(45);
		m4.setPeriodicity(Periodicity.BIANNUAL);
		printDAO.savePrint(m4);
	}

	public static void generateUsers() {
		Utente u1 = new Utente("Andrea", "Bardi", LocalDate.of(2022,10,28));
		prestDAO.saveUser(u1);
		
		Utente u2 = new Utente("Federico", "Rossi", LocalDate.of(1982,9,10));
		prestDAO.saveUser(u2);
		
		Utente u3 = new Utente("Gianluca", "Verdi", LocalDate.of(1995,3,29));
		prestDAO.saveUser(u3);
	}

	public static void generatePrestiti() {
		
		Book b1 = printDAO.getBook(1);
		Magazine m3 = printDAO.getMagazine(3);
		Utente u1 = prestDAO.getUser(1);
		Prestito p1 = new Prestito(u1, b1, m3, LocalDate.now(),
								   LocalDate.now().plusDays(30));
		prestDAO.savePrestito(p1);
		
		Book b2 = printDAO.getBook(2);
		Magazine m1 = printDAO.getMagazine(1);
		Utente u2 = prestDAO.getUser(2);
		Prestito p2 = new Prestito(u2, b2, m1, LocalDate.now(),
								   LocalDate.now().plusDays(30));
		prestDAO.savePrestito(p2);
	}
}
