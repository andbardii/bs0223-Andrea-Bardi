package com.esercizio.due;

import java.util.Random;

public class MainDue {
	
	public static Random rand = new Random();
	
	public static void main(String[] args) throws InterruptedException {
		
		int[] numbArray = new int[3000];
		int[] radomArray = handleArray(numbArray);
		
		FirstThread t1 = new FirstThread(radomArray);
		t1.start();
		t1.join();
		
		SecondThread t2 = new SecondThread(radomArray);
		t2.start();
		t2.join();
		
		ThirdThread t3 = new ThirdThread(radomArray);
		t3.start();
		t3.join();
		
		int s1 = t1.getSomma();
		
		int s2 = t2.getSomma();
		
		int s3 = t3.getSomma();
		
		
		System.out.println("La somma totale è: " + sommaTre(s1, s2, s3));
		
	}
	public static int[] handleArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100);
		}
		return arr;
	}
	
public static int sommaTre(int n1, int n2, int n3) {
		int sum = n1 + n2 + n3;
		return sum;
	}
}
