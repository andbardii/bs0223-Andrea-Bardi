package com.esercizio.uno;

public class MainUno {
	
	public static void main(String[] args) throws InterruptedException{
		
		ThreadUno t1 = new ThreadUno("#");
		ThreadUno t2 = new ThreadUno("*");
		
		t1.start();
		t2.start();
		
		System.out.println("Io lavoro su un'altro piano :b");
		
	}

}
