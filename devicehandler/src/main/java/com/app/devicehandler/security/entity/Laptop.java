package com.app.devicehandler.security.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("laptop")
public class Laptop extends Device{
	
	public Laptop() {
		this.setDevType(TypeOfDevice.LAPTOP);
		this.setStatus(TypeOfStatus.AVAILABLE);
	}

}
