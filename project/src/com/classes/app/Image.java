package com.classes.app;

import com.iterfaces.app.Bright;

public class Image extends Multimedia implements Bright{

	
	
	@Override
	public void upperBrightness() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lowerBrightness() {
		// TODO Auto-generated method stub
		
	}
	
	public Image(String title) {
		super();
		this.title = title;
	}
	
}
