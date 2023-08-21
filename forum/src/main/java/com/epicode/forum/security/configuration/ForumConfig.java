package com.epicode.forum.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.epicode.forum.security.entity.Answer;
import com.epicode.forum.security.entity.Post;

@Configuration
public class ForumConfig {

	
	@Bean("post")
	@Scope("prototype")
	public Post post() {
		return new Post();
	}
	
	@Bean("answer")
	@Scope("prototype")
	public Answer answer() {
		return new Answer();
	}
	
}
