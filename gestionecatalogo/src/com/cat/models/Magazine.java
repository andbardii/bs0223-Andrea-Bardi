package com.cat.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;

import com.cat.enums.Periodicity;

@Entity
@NamedQuery(name = "Magazine.findByDate", query = "SELECT m FROM Magazine m WHERE m.date = :magazine_data")
@NamedQuery(name = "Magazine.findByTitle", query = "SELECT m FROM Magazine m WHERE m.title LIKE :magazine_title") 
public class Magazine extends Printable{
	
	@Enumerated(EnumType.STRING)
	private Periodicity periodicity;

	public Magazine() {
		super();
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
	

}
