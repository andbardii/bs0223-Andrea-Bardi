package com.classes.app;

import com.iterfaces.app.Playable;

public class Audio extends Multimedia implements Playable{;

	public int duration;
	public int volume = 0;
	
	@Override
	public void play() {
		
		for(int i = 0; i<this.duration; i++) {
			System.out.print(this.title);
		}
		System.out.println();
		for(int i = 0; i<this.volume; i++) {
			System.out.print("!");
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

	
	public Audio(int duration, String title) {
		super();
		this.duration = duration;
		this.title = title;
	}

	
}
