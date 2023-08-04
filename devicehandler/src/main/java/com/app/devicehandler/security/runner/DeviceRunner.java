package com.app.devicehandler.security.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.devicehandler.security.entity.TypeOfDevice;
import com.app.devicehandler.security.service.DeviceService;

@Component
public class DeviceRunner implements CommandLineRunner{

	@Autowired DeviceService devSvc;
	
	@Override
	public void run(String... args) throws Exception {
		
		// ADD DEVICES
//		devSvc.addDevice(TypeOfDevice.SMARTPHONE);
//		devSvc.addDevice(TypeOfDevice.TABLET);
//		devSvc.addDevice(TypeOfDevice.LAPTOP);
//		devSvc.addDevice(TypeOfDevice.SMARTPHONE);
//		devSvc.addDevice(TypeOfDevice.SMARTPHONE);
//		devSvc.addDevice(TypeOfDevice.SMARTPHONE);
//		devSvc.addDevice(TypeOfDevice.LAPTOP);
//		devSvc.addDevice(TypeOfDevice.TABLET);
//		devSvc.addDevice(TypeOfDevice.LAPTOP);
//		devSvc.addDevice(TypeOfDevice.SMARTPHONE);
//		devSvc.addDevice(TypeOfDevice.LAPTOP);
		
		// ASSIGN DEVICES
//		devSvc.assignDevice(1, TypeOfDevice.SMARTPHONE);
//		devSvc.assignDevice(1, TypeOfDevice.TABLET);
//		devSvc.assignDevice(1, TypeOfDevice.LAPTOP);
		
		// DISUSE DEVICES
//		devSvc.disuseDevice(1);
//		devSvc.disuseDevice(1);
//		devSvc.disuseDevice(10);
//		devSvc.disuseDevice(3);
		
		// TOGGLE DEVICE
//		devSvc.toggleMaintenance(2);
//		devSvc.toggleMaintenance(2);
//		devSvc.toggleMaintenance(5);
//		devSvc.toggleMaintenance(7);
		
		
		
		
		
	}

}
