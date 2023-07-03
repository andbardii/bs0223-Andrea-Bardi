package com.esercizio.tre.app;

public class BancaException extends Exception{
	
	public String message;

	public BancaException (String message) {
		this.message = message;
	}

	public String toString() {
		return message;
	}
	
}
