package com.esercizio.due;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecondThread extends Thread{
	
	private Logger log = LoggerFactory.getLogger(SecondThread.class);
	
	private int somma;
	private int[] numbArr;
	
	public SecondThread(int[] arr) {
		this.numbArr = arr;
	}
	
	public int getSomma() {
		return somma;
	}
	
	@Override
	public void run() {
		for(int i = 1000; i<2000; i++) {
			this.somma += this.numbArr[i];
		}
		log.info("Terza somma completata");
	}
}
