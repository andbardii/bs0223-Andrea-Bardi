package com.app.springfirst.configuration.config_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigurationTest {
	
	@Bean
	@Scope("singleton")
	public Test test() {
		return new Test("Ciao Mondo");
	}
	
	@Bean
	@Scope("prototype") 
	public Test testParam(String txt) {
		return new Test(txt);
	}
}
