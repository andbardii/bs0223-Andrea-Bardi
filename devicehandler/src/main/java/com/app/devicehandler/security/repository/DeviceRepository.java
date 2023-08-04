package com.app.devicehandler.security.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.devicehandler.security.entity.Device;
import com.app.devicehandler.security.entity.TypeOfDevice;
import com.app.devicehandler.security.entity.TypeOfStatus;

public interface DeviceRepository extends CrudRepository<Device, Long> {

	public List<Device> findByDevType(TypeOfDevice devType);
	public List<Device> findByStatus(TypeOfStatus status);
	public List<Device> findByDevTypeAndStatus(TypeOfDevice devType, TypeOfStatus status);
	
}
