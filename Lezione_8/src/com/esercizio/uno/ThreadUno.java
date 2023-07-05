package com.esercizio.uno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadUno extends Thread{

	private   Logger log = LoggerFactory.getLogger(ThreadUno.class);
	
	private String mess;
	
	public ThreadUno(String m) {
		this.mess = m;
	}	
	
	@Override
	public void run() {
		
		int i = 0;
		while(i<10) {
			try {
				log.info((i+1) + " " + mess);
				sleep(1000);
				i++;
			}catch (InterruptedException e) {
				log.error(e.getMessage());
			}
		}
	}
}
