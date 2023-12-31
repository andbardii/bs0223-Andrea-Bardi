package com.classes.app;

import com.enums.app.Periodicity;

public class Magazine extends Printable{
	
	private Periodicity periodicity;

	public Magazine(String ISBN, String title, int pages, Periodicity periodicity, int date) {
		super(ISBN, title, pages, date);
		this.periodicity = periodicity;
	}

	public Periodicity getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(Periodicity periodicity) {
		this.periodicity = periodicity;
	}
	
	@Override
	public String toString() {
		return "(MAGAZINE) ISBN: " + this.getISBN() + ", Title: " + this.getTitle() + ", Date: " + this.getDate() + ", Pages: " + this.getPages() + ", Periodicity: " + periodicity;
	}
	
	public String toFile() {
		return "@" + this.getISBN() + "#" + this.getTitle() + "#" + this.getDate() + "#" + this.getPages() + "#" + periodicity;
	}

}
