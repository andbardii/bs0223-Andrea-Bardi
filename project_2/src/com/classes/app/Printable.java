package com.classes.app;

public abstract class Printable {

	private String ISBN;
	private String title;
	private int date;
	private int pages;
	
	public Printable(String ISBN, String title, int pages, int date) {
		this.ISBN = ISBN;
		this.title = title;
		this.date = date;
		this.pages = pages;
	}
	
	public String getISBN() {
		return ISBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
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
