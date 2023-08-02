package com.project.app;

import java.util.Scanner;

import com.classes.app.Multimedia;
import com.classes.app.Audio;
import com.classes.app.Image;
import com.classes.app.Video;

public class Project {
	
	static Scanner scan = new Scanner(System.in);
	
	static Multimedia[] MediasArr = new Multimedia[5];

	public static void main(String[] args) {
		
		generateMultimedia();
		handleMultimedia();		
	}
	
	public static void generateMultimedia() {
		
		int x = 0;
		do {
		int type;
		System.out.println("1: Video, 2: Image, 3: Audio");
		
		System.out.println("Insert the type of media: ");
		if(scan.hasNextInt()) {
		type = scan.nextInt();
			
        switch(type) {
        case 1:
        	
        	x++;
        	
        	System.out.println("Insert title: ");
        	String titleVideo;
        	if(!scan.hasNextInt()) {
        	titleVideo = scan.next();
        	
        	System.out.println("Insert duration: ");
            int durationVideo = scan.nextInt();
            
            MediasArr[x-1] = new Video(durationVideo, titleVideo);
            
            
            break;
}
            
        case 2:
        	
        	x++;
        	
        	System.out.println("Insert title: ");
        	String titleImage = scan.next();
            
        	MediasArr[x-1] = new Image(titleImage);
            
            break;
            
        case 3:
        	
        	x++;
        	
        	System.out.println("Insert title: ");
        	String titleAudio = scan.next();
        	
        	System.out.println("Insert duration: ");
            int durationAudio = scan.nextInt();
            
            MediasArr[x-1] = new Audio(durationAudio, titleAudio);
            
            break;
        	
        default:
        	
        	System.out.println("Isert a valid Multimedia number");
        	scan.next();
        	
        }
        }else {
        	
        	System.out.println("Isert number!");
        	scan.next();
        	
        }
        }
        while ( x < 5 );
        
	}

	public static void handleMultimedia() {
		int i = 0;
		while(i == 0 ) {
			System.out.println("Insert a number between 1 and 5 (0 to block the system)");
			
			System.out.println("Choose a media: ");
	        int media = scan.nextInt();
	        switch(media) {
	        case 0: 
	        	i = 1;
	        	break;
	        default:
	        	 if(MediasArr[media-1] instanceof Audio) {
	        		Audio aud = (Audio)MediasArr[media-1];
	        		
	        		System.out.println("Choose the volume (from 1 to 10): ");
	    	        int vol = scan.nextInt();
	    	        
	    	        for(int y = 0; y < vol; y++) {
	    	        	aud.upperVolume();
	    	        }
	    	        
	        		aud.play();
	        	 }else if(MediasArr[media-1] instanceof Video) {
	        		 Video vid = (Video)MediasArr[media-1];
	        		 
	        		 System.out.println("Choose the volume (from 1 to 10): ");
		    	        int vol = scan.nextInt();
		    	        
		    	        for(int y = 0; y < vol; y++) {
		    	        	vid.upperVolume();
		    	        }
		    	        
		    	        System.out.println("Choose the brightness (from 1 to 10): ");
		    	        int bright = scan.nextInt();
		    	        
		    	        for(int y = 0; y < bright; y++) {
		    	        	vid.upperBrightness();
		    	        }
		    	        
	        		 vid.play();
	        	 }else if(MediasArr[media-1] instanceof Image) {
	        		 Image img = (Image)MediasArr[media-1];
	        		 
	        		 System.out.println("Choose the brightness (from 1 to 10): ");
		    	        int bright = scan.nextInt();
		    	        
		    	        for(int y = 0; y < bright; y++) {
		    	        	img.upperBrightness();
		    	        }
	        		 
	        		 img.show();
	        	 }
	        		 
	        	 break;
	        }
	       
		}
		
	}
}
