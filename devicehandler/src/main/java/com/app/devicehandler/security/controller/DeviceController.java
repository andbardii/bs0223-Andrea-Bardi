package com.app.devicehandler.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.devicehandler.security.entity.Device;
import com.app.devicehandler.security.entity.TypeOfDevice;
import com.app.devicehandler.security.entity.TypeOfStatus;
import com.app.devicehandler.security.service.DeviceService;

@RestController
@RequestMapping("/api/device")
public class DeviceController {

	@Autowired DeviceService devSvc;
	
	// GET API METHODS
	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<Device>> findAll() {
		List<Device> list = devSvc.findAll();
		ResponseEntity<List<Device>> resp = new ResponseEntity<List<Device>>(list, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/status")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findByStatus(@RequestBody TypeOfStatus status) {
		List<Device> list = devSvc.findByStatus(status);
		ResponseEntity<List<Device>> resp = new ResponseEntity<List<Device>>(list, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Device d = devSvc.findById(id);
		ResponseEntity<Device> resp = new ResponseEntity<Device>(d, HttpStatus.OK);
		return resp;
	}
	
	// POST API METHODS
	@PostMapping
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> addDevice(@RequestBody TypeOfDevice devType) {
		Device d = devSvc.addDevice(devType);
		return new ResponseEntity<Device>(d, HttpStatus.CREATED);
	}
	
	// PUT API METHODS
	@PutMapping("/smartphone/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> assignSmartphone(@PathVariable Long id) {
		Device d = devSvc.assignDevice(id, TypeOfDevice.SMARTPHONE);
		return new ResponseEntity<Device>(d, HttpStatus.OK);
	}
	
	@PutMapping("/tablet/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> assignTablet(@PathVariable Long id) {
		Device d = devSvc.assignDevice(id, TypeOfDevice.TABLET);
		return new ResponseEntity<Device>(d, HttpStatus.OK);
	}
	
	@PutMapping("/laptop/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> assignLaptop(@PathVariable Long id) {
		Device d = devSvc.assignDevice(id, TypeOfDevice.LAPTOP);
		return new ResponseEntity<Device>(d, HttpStatus.OK);
	}
	
	@PutMapping("/disuse/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> disuseDevice(@PathVariable Long id) {
		Device d = devSvc.disuseDevice(id);
		return new ResponseEntity<Device>(d, HttpStatus.OK);
	}
	
	@PutMapping("/toggle/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> toggleDevice(@PathVariable Long id) {
		Device d = devSvc.toggleMaintenance(id);
		return new ResponseEntity<Device>(d, HttpStatus.OK);
	}
	
}
