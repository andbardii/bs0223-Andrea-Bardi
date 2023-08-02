package com.classes.app;

import com.iterfaces.app.Bright;

public class Image extends Multimedia implements Bright{

	public int brightness = 0;
	
	public void show() {
		System.out.println(this.title);
		for(int i = 0; i<this.brightness; i++) {
			System.out.print("*");
		}
		System.out.println();

	}
	
	@Override
	public int upperBrightness() {
		if(this.brightness == 10) {
			System.out.println("Luminosità massima!");
			return this.brightness = 10;
		}
		else{return this.brightness++;}
		
	}

	@Override
	public int lowerBrightness() {
		if(this.brightness == 0) {
			System.out.println("Luminosità minima!");
			return this.brightness = 0;
		}
		else{return this.brightness--;}
		
	}
	
	public Image(String title) {
		super();
		this.title = title;
	}
	
}
