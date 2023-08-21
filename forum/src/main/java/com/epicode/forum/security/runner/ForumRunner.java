package com.epicode.forum.security.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.forum.security.service.FService;

@Component
public class ForumRunner implements CommandLineRunner{

	@Autowired FService svc;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		ADD POSTS
		svc.addPost("How can i learn javascript with Michele?");
		svc.addPost("How can i learn sql?");
		svc.addPost("How can i learn html?");
		
//		ADD ANSWERS
		svc.addAnswer(1,"Impossible!!!");
//		svc.addAnswer(1,"You are joking...");
		svc.addAnswer(2,"Study!");
		svc.addAnswer(3,"Study!");
		
	}
	

}
