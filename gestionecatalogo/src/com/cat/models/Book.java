package com.cat.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;

import com.cat.enums.Type;

@Entity
@NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title LIKE :book_title")
@NamedQuery(name = "Book.findByDate", query = "SELECT b FROM Book b WHERE b.date = :book_data") 
@NamedQuery(name = "Book.findByAuthor", query = "SELECT b FROM Book b WHERE b.author LIKE :author_name") 
public class Book extends Printable{
	
	private String author;
	
	@Enumerated(EnumType.STRING)
	private Type type;
	
	public Book() {
		super();
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
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
		return "(BOOK) Author: " + author + ", Type: " + type + ", ISBN: " + this.getISBN() + ", Title: " + this.getTitle() + ", Date: " + this.getDate() + ", Pages: " + this.getPages();
	}
	
}
