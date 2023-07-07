package com.classes.app;

import com.enums.app.Country;

public class Author {

	private int id;
	private String name;
	private Country country;
	
	public Author(int id, String name, Country country) {
		this.id = id;
		this.name = name;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "(AUTHOR) Id: " + id + ", Name: " + name + ", Country: " + country;
	}
	
	public String toFile() {
		return id + "#" + name + "#" + country;
	}
	
	
}
