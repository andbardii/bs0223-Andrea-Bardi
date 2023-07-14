package com.cat.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Printable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ISBN;
	
	private String title;
	
	private int date;
	
	private int pages;
	
	public Printable() {
		super();
	}
	
	public Long getISBN() {
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

}
