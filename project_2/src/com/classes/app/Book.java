package com.classes.app;

import com.enums.app.Type;

public class Book extends Printable{
	
	private Author author;
	private Type type;
	
	public Book(String ISBN,String title, int pages, Author author, Type type, int date) {
		super(ISBN, title, pages, date);
		this.author = author;
		this.type = type;
	}

	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "(BOOK) Author: " + author.getName() + ", Type: " + type + ", ISBN: " + this.getISBN() + ", Title: " + this.getTitle() + ", Date: " + this.getDate() + ", Pages: " + this.getPages();
	}
	
	public String toFile() {
		return "@" + getAuthor().toFile() + "#" + type + "#"+ this.getISBN() + "#" + this.getTitle() + "#" + this.getDate() + "#" + this.getPages();
	}


	
}
