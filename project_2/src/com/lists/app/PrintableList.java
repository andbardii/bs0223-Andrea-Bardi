package com.lists.app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

import com.classes.app.Author;
import com.classes.app.Book;
import com.classes.app.Magazine;
import com.classes.app.Printable;
import com.enums.app.Country;
import com.enums.app.Periodicity;
import com.enums.app.Type;

public class PrintableList {
	
	private static File file = new File("doc/test.txt");
	
	private List<Printable> List;

	public PrintableList() {
		List = new ArrayList<Printable>();
	}
	
	public void addPrintable(Printable p) {
		if(p instanceof Book) {
			List.add(p);
			writeOnFile(p);
		}else if(p instanceof Magazine) {
			List.add(p);
			writeOnFile(p);
		}
	}
	
	public void addBook(String ISBN, String title, int pages, Author author, Type type, int date) {
		List.add(new Book(ISBN, title, pages, author, type, date));
		writeOnFile(new Book(ISBN, title, pages, author, type, date));
	}
	
	private void restoreBook(String ISBN, String title, int pages, Author author, Type type, int date) {
		List.add(new Book(ISBN, title, pages, author, type, date));
	}
	
	public void addMagazine(String ISBN, String title, int pages, Periodicity periodicity, int date) {
		List.add(new Magazine(ISBN, title, pages, periodicity, date));
		writeOnFile(new Magazine(ISBN, title, pages, periodicity, date));
	}
	
	private void restoreMagazine(String ISBN, String title, int pages, Periodicity periodicity, int date) {
		List.add(new Magazine(ISBN, title, pages, periodicity, date));
	}
	
	public void printAllPrintable() {
			for(int i=0; i<List.size(); i++) {
				System.out.println(List.get(i).toString());
			}
	}
	
	public void findByISBN(String ISBN) {
		List<Printable> choosedPrintable = List.stream()
				.filter(p -> p.getISBN().equals(ISBN))
				.collect(Collectors.toList());
		choosedPrintable.forEach(p -> System.out.println(p.toString()));
	}
	
	public void deleteByISBN(String ISBN) {
		List<Printable> deletedPrintable = List.stream()
				.filter(p -> p.getISBN().equals(ISBN))
				.collect(Collectors.toList());
			deletedPrintable.forEach(p -> {
				System.out.println("Printable: " + p.getTitle() + ", removed succesfully.");
				List.remove(p);
			});
	}
	
	public void findByYear(int year) {
		List<Printable> choosedPrintable = List.stream()
				.filter(p -> p.getDate() == year)
				.collect(Collectors.toList());
		choosedPrintable.forEach(p -> System.out.println(p.toString()));
	}
	
	public void findByAuthor(Author aut) {
		List<Book> choosedPrintable = List.stream()
				.filter(p -> p instanceof Book)
				.map(b -> (Book)b)
				.filter(b -> b.getAuthor().getName().equals(aut.getName()))
				.collect(Collectors.toList());
		
		choosedPrintable.forEach(p -> System.out.println(p.toString()));
	}
	public void findByAuthorName(Author aut) {
		List<Book> choosedPrintable = List.stream()
				.filter(p -> p instanceof Book)
				.map(b -> (Book)b)
				.filter(b -> b.getAuthor().getName().equals(aut.getName()))
				.collect(Collectors.toList());
		
		choosedPrintable.forEach(p -> System.out.println(p.toString()));
	}
	
	private void writeOnFile(Printable p){
		try {
			FileUtils.writeStringToFile(file, p.toFile() , "UTF-8", true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void clearFile(){
		FileUtils.deleteQuietly(file);
	}

	public void restoreFromFile() {
		try {
			String textTotal = FileUtils.readFileToString(file, "UTF-8");
			String[] fileText = textTotal.split("@");
		
			for (String text : fileText) {
				if(text == fileText[0]){
					continue;
				}else if(!checkPrintable(text)) {
					String[] magazine = text.split("#");
					
					int pages = Integer.parseInt(magazine[3]);
					int date = Integer.parseInt(magazine[2]);

					
					restoreMagazine(magazine[0], magazine[1], pages, selectPeriodicity(magazine[4]), date);
					
				}else if(checkPrintable(text)) {
					String[] book = text.split("#");
					
					int pages = Integer.parseInt(book[7]);
					int date = Integer.parseInt(book[6]);
					
					restoreBook(book[4], book[5], pages, generateAuthor(book[0],book[1], book[2]), selectType(book[3]), date);
				}
		        
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private boolean checkPrintable(String s) {
		String[] printable = s.split("#");
		
		if(printable.length < 8) {
			return false;
		}else{
			return true;
		}
		
	}
	
	private Country selectCountry(String s) {
		switch(s) {
		case "ITALY": 
			return Country.ITALY;
		case "SPAIN":
			return Country.SPAIN;
		case "JAPAN":
			return Country.JAPAN;
		case "NETHERLAND":
			return Country.NETHERLAND;
		case "USA":
			return Country.USA;
		case "RUSSIA":
			return Country.RUSSIA;
		case "GERMANY":
			return Country.GERMANY;
		case "ENGLAND":
			return Country.ENGLAND;
		case "COLOMBIA":
			return Country.COLOMBIA;
		default:
			return null;
		}
	}

	private Periodicity selectPeriodicity(String s) {
		switch(s) {
		case "DAILY":
			return Periodicity.DAILY;
		case "WEEKLY":
			return Periodicity.WEEKLY;
		case "MONTHLY":
			return Periodicity.MONTHLY;
		case "BIANNUAL":
			return Periodicity.BIANNUAL;
		case "ANNUAL":
			return Periodicity.ANNUAL;
		default:
			return null;	
		}
	}

	private Type selectType(String s) {
		switch(s) {
		case "FANTASY":
			return Type.FANTASY;
		case "NOIR":
			return Type.NOIR;
		case "HORROR":
			return Type.HORROR;
		case "THRILLER":
			return Type.THRILLER;
		case "DISTOPIC":
			return Type.DISTOPIC;
		case "SCHOOL":
			return Type.SCHOOL;
		case "NOVEL":
			return Type.NOVEL;
		default:
			return null;	
		}
	}
	
	private Author generateAuthor(String id, String name, String country) {
		int authorid = Integer.parseInt(id);
		return new Author(authorid, name, selectCountry(country));
	}
}
