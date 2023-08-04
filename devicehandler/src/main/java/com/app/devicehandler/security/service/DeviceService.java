package com.app.devicehandler.security.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.devicehandler.security.entity.Device;
import com.app.devicehandler.security.entity.Laptop;
import com.app.devicehandler.security.entity.Smartphone;
import com.app.devicehandler.security.entity.Tablet;
import com.app.devicehandler.security.entity.TypeOfDevice;
import com.app.devicehandler.security.entity.TypeOfStatus;
import com.app.devicehandler.security.entity.User;
import com.app.devicehandler.security.repository.DeviceRepository;

@Service
public class DeviceService {

	private Logger log = LoggerFactory.getLogger(DeviceService.class);

	@Autowired DeviceRepository devRepo;
	@Autowired UserService useSvc;
	
	@Autowired @Qualifier("smartphone") private ObjectProvider<Smartphone> smartphoneProvider;
	@Autowired @Qualifier("tablet") private ObjectProvider<Tablet> tabletProvider;
	@Autowired @Qualifier("laptop") private ObjectProvider<Laptop> laptopProvider;
	
	// SAVE METHODS
	public Device addDevice(TypeOfDevice type) {
		switch(type) {
		case SMARTPHONE:
			Smartphone s = smartphoneProvider.getObject();
			devRepo.save(s);
			log.info("Smartphone saved with id: " + s.getId());
			return s;
		case TABLET:
			Tablet t = tabletProvider.getObject();
			devRepo.save(t);
			log.info("Tablet saved with id: " + t.getId());
			return t;
		case LAPTOP:
			Laptop l = laptopProvider.getObject();
			devRepo.save(l);
			log.info("Laptop saved with id: " + l.getId());
			return l;
		default:
			return null;
		}
	}
	
	// FIND METHODS
	public Device findById(long id) {
		Device d = devRepo.findById(id).get();
		log.info(d.toString());
		return d;
	}
	
	public List<Device> findAll(){
		List<Device> l = (List<Device>)devRepo.findAll();
		l.forEach(d -> log.info(d.toString()));
		return l;
	}
	
	public List<Device> findByType(TypeOfDevice type) {
		List<Device> l = devRepo.findByDevType(type);
		l.forEach(d -> log.info(d.toString()));
		return l;
	}
	
	public List<Device> findByStatus(TypeOfStatus status) {
		List<Device> l = devRepo.findByStatus(status);
		l.forEach(d -> log.info(d.toString()));
		return l;
	}
	
	// SPECIAL METHODS
	public Device assignDevice(long id, TypeOfDevice type) {
		User u = useSvc.findById(id);
		List<Device> l = devRepo.findByDevTypeAndStatus(type, TypeOfStatus.AVAILABLE);
		if(l.size() == 0) {
			log.info("There are no available devices of this type!");
			return null;
		}else {
			Device d = l.get(0);
			d.setUser(u);
			d.setStatus(TypeOfStatus.ASSIGNED);
			devRepo.save(d);
			log.info("Device id: " + d.getId() + " assigned to " + u.getName());
			return d;
		}
		
	}
	
	public Device disuseDevice(long id) {
		Device d = findById(id);
		if(d.getStatus().equals(TypeOfStatus.DISUSED)) {
			log.info("Device id: " + d.getId() + " is already disused.");
			return d;
		}else {
			d.setStatus(TypeOfStatus.DISUSED);
			d.setUser(null);
			devRepo.save(d);
			log.info("Device id: " + d.getId() + " is definitively disused.");
			return d;
		}
	}
	
	public Device toggleMaintenance(long id) {
		Device d = findById(id);
		if(d.getStatus().equals(TypeOfStatus.ASSIGNED) || d.getStatus().equals(TypeOfStatus.AVAILABLE)) {
			d.setStatus(TypeOfStatus.MAINTENANCE);
			d.setUser(null);
			devRepo.save(d);
			log.info("Device id: " + d.getId() + " is now under maintenance.");
			return d;
		}else if(d.getStatus().equals(TypeOfStatus.MAINTENANCE)) {
			d.setStatus(TypeOfStatus.AVAILABLE);
			devRepo.save(d);
			log.info("Device id: " + d.getId() + " is now available.");
			return d;
		}else {
			log.info("Device id: " + d.getId() + " is definitively disused.");
			return null;
		}
	}
}
