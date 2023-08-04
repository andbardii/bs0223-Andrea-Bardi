package com.app.devicehandler.security.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("smartphone")
public class Smartphone extends Device {
	
	public Smartphone() {
		this.setDevType(TypeOfDevice.SMARTPHONE);
		this.setStatus(TypeOfStatus.AVAILABLE);
	}

}
