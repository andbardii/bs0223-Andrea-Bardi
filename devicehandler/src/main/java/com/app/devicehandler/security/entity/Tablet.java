package com.app.devicehandler.security.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("tablet")
public class Tablet extends Device {

	public Tablet() {
		this.setDevType(TypeOfDevice.TABLET);
		this.setStatus(TypeOfStatus.AVAILABLE);
	}
}
