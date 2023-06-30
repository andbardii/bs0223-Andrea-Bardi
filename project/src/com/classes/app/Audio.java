package com.classes.app;

import com.iterfaces.app.Playable;

public class Audio extends Multimedia implements Playable{;

	public int duration;
	
	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upperVolume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lowerVolume() {
		// TODO Auto-generated method stub
		
	}

	
	public Audio(int duration, String title) {
		super();
		this.duration = duration;
		this.title = title;
	}

	
}
