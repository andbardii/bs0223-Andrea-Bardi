package com.app.springfirst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.springfirst.dipendencyinjection.ProdottoConfiguration;

@SpringBootApplication
public class SpringfirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringfirstApplication.class, args);
	}

	public static void configWith_BeansDependencyInjection() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ProdottoConfiguration.class);
	
		appContext.close();
	}
}
