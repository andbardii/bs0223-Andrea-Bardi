package com.classes.app;

import java.time.LocalDate;

public abstract class Printable {

	private int ISBN;
	private String title;
	private LocalDate date;
	private int pages;
	
	public Printable(int ISBN, String title, int pages, LocalDate date) {
		this.ISBN = ISBN;
		this.title = title;
		this.date = date;
		this.pages = pages;
	}
	
	public int getISBN() {
		return ISBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public abstract String toFile();
}
