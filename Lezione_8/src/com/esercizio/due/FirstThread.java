package com.esercizio.due;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstThread extends Thread{
	
	private Logger log = LoggerFactory.getLogger(FirstThread.class);
	
	private int somma;
	private int[] numbArr;
	
	public FirstThread(int[] arr) {
		this.numbArr = arr;
	}
	
	public int getSomma() {
		return somma;
	}
	
	@Override
	public void run() {
		for(int i = 0; i<1000; i++) {
			this.somma += this.numbArr[i];
		}
		log.info("Prima somma completata");
	}

}
