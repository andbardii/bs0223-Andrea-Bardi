package com.classes.app;

import com.iterfaces.app.Bright;
import com.iterfaces.app.Playable;

public class Video extends Multimedia implements Playable, Bright{
	
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

	@Override
	public void upperBrightness() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lowerBrightness() {
		// TODO Auto-generated method stub
		
	}

	
	public Video(int duration, String title) {
		super();
		this.duration = duration;
		this.title = title;
	}

	
	
	
}
