package com.project.app;

import java.util.Scanner;

import com.classes.app.Multimedia;
import com.classes.app.Audio;
import com.classes.app.Image;
import com.classes.app.Video;

public class Project {
	
	static Scanner scan = new Scanner(System.in);
	
	static Multimedia[] Array = new Multimedia[5];

	public static void main(String[] args) {
		
		generateMultimedia();
		
	}
	
	public static void generateMultimedia() {
		
		int x = 0;
		do {
		
		System.out.println("1: Video, 2: Image, 3: Audio");
		System.out.println("Insert the type of media: ");
        int type = scan.nextInt();
        	
        switch(type) {
        case 1:
        	
        	x++;
        	
        	System.out.println("Insert title: ");
        	String titleVideo = scan.next();
        	
        	System.out.println("Insert duration: ");
            int durationVideo = scan.nextInt();
            
            Array[x-1] = new Video(durationVideo, titleVideo);
            
            
            break;
            
            
        case 2:
        	
        	x++;
        	
        	System.out.println("Insert title: ");
        	String titleImage = scan.next();
            
        	 Array[x-1] = new Image(titleImage);
            
            break;
            
        case 3:
        	
        	x++;
        	
        	System.out.println("Insert title: ");
        	String titleAudio = scan.next();
        	
        	System.out.println("Insert duration: ");
            int durationAudio = scan.nextInt();
            
            Array[x-1] = new Audio(durationAudio, titleAudio);
            
            break;
        	
        default:
        	
        	System.out.println("Isert a valid Multimedia number");
        	
        }
        }
        while ( x < 5 );
        
	}

}
