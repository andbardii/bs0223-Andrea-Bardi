package com.esercizio.due;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThirdThread extends Thread{
	
	private Logger log = LoggerFactory.getLogger(ThirdThread.class);
	
	private int somma;
	private int[] numbArr;
	
	public ThirdThread(int[] arr) {
		this.numbArr = arr;
	}
	
	public int getSomma() {
		return somma;
	}
	
	@Override
	public void run() {
		for(int i = 2000; i < 3000; i++) {
			this.somma += this.numbArr[i];
		}
		log.info("Seconda somma completata");
	}

}
