package com.esercizio.stream;

import java.util.Random;

public class Customer {
	
	public static Random rand = new Random();
	
	public long id;
	public String name;
	public Integer tier;
	
	public Customer(String name, Integer tier) {
		this.id = rand.nextLong(1000)+rand.nextLong(1000);
		this.name = name;
		this.tier = tier;
	}
	public Integer getTier() {
        return this.tier;
    }
	
}
