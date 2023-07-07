package com.lists.app;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

import com.classes.app.Author;
import com.classes.app.Book;
import com.classes.app.Magazine;
import com.classes.app.Printable;
import com.enums.app.Periodicity;
import com.enums.app.Type;

public class PrintableList {
	
	private static File file = new File("doc/test.txt");
	
	private List<Printable> List;

	public PrintableList() {
		List = new ArrayList<Printable>();
		clearFile();
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
	
	public void addBook(int ISBN, String title, int pages, Author author, Type type, LocalDate date) {
		List.add(new Book(ISBN, title, pages, author, type, date));
		writeOnFile(new Book(ISBN, title, pages, author, type, date));
	}
	
	public void addMagazine(int ISBN, String title, int pages, Periodicity periodicity, LocalDate date) {
		List.add(new Magazine(ISBN, title, pages, periodicity, date));
		writeOnFile(new Magazine(ISBN, title, pages, periodicity, date));
	}
	
	public void printAllPrintable() {
			for(int i=0; i<List.size(); i++) {
				System.out.println(List.get(i).toString());
			}
	}
	
	public void findByISBN(int ISBN) {
		List<Printable> choosedPrintable = List.stream()
				.filter(p -> p.getISBN() == ISBN)
				.collect(Collectors.toList());
		choosedPrintable.forEach(p -> System.out.println(p.toString()));
	}
	
	public void deleteByISBN(int ISBN) {
		List<Printable> deletedPrintable = List.stream()
				.filter(p -> p.getISBN() == ISBN)
				.collect(Collectors.toList());
			deletedPrintable.forEach(p -> {
				System.out.println("Printable: " + p.getTitle() + ", removed succesfully.");
				List.remove(p);
			});
	}
	
	public void findByYear(int year) {
		List<Printable> choosedPrintable = List.stream()
				.filter(p -> p.getDate().getYear() == year)
				.collect(Collectors.toList());
		choosedPrintable.forEach(p -> System.out.println(p.toString()));
	}
	
	public void findByAuthor(Author aut) {
		List<Book> choosedPrintable = List.stream()
				.filter(p -> p instanceof Book)
				.map(b -> (Book)b)
				.filter(b -> b.getAuthor() == aut)
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
			String[] fileText = textTotal.split("$");
			for (String text : fileText) {
				if(text.startsWith(Magazine.class.getSimpleName())) {
					String[] magazine = text.split("#");
					int ISBN = Integer.parseInt(magazine[0]);
					int pages = Integer.parseInt(magazine[2]);
					Author author = new Author()
					addMagazine(ISBN, magazine[1], pages, magazine[3]);
					
				}else if(text.startsWith(Book.class.getSimpleName())) {
					String[] book = text.split("#");

				}
		        
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
