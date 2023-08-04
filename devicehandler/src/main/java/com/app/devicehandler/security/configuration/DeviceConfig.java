package com.app.devicehandler.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.app.devicehandler.security.entity.Laptop;
import com.app.devicehandler.security.entity.Smartphone;
import com.app.devicehandler.security.entity.Tablet;

@Configuration
@PropertySource("classpath:application.properties")
public class DeviceConfig {
	
	@Bean("smartphone")
	@Scope("prototype")
	public Smartphone smartphone() {
		return new Smartphone();
	}
	
	@Bean("laptop")
	@Scope("prototype")
	public Laptop laptop() {
		return new Laptop();
	}
	
	@Bean("tablet")
	@Scope("prototype")
	public Tablet tablet() {
		return new Tablet();
	}

}
