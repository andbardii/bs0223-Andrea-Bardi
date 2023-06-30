package com.classes.app;

import com.iterfaces.app.Bright;
import com.iterfaces.app.Playable;

public class Video extends Multimedia implements Playable, Bright{
	
	public int duration;
	public int volume = 0;
	public int brightness = 0;

	@Override
	public void play() {
		
		for(int i = 0; i<this.duration; i++) {
			System.out.print(this.title);
		}
		for(int i = 0; i<this.volume; i++) {
			System.out.print("!");
		}
		System.out.println();
		for(int i = 0; i<this.brightness; i++) {
			System.out.print("*");
		}
		System.out.println();
	}

	@Override
	public int upperVolume() {
		if(this.volume == 10) {
			System.out.println("Volume massimo!");
			return this.volume = 10;
		}
		else{return this.volume++;}
		
	}

	@Override
	public int lowerVolume() {
		if(this.volume == 0) {
			System.out.println("Volume minimo!");
			return this.volume = 0;
		}
		else{return this.volume--;}
		
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

	
	public Video(int duration, String title) {
		super();
		this.duration = duration;
		this.title = title;
	}

	
	
	
}
