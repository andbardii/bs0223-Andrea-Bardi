package com.app.devicehandler.security.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.devicehandler.security.entity.User;
import com.app.devicehandler.security.repository.UserRepository;

@Service
public class UserService {

	private Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired UserRepository repo;

	// FIND METHODS
	public User findById(long id) {
		User u = repo.findById(id).get();
		log.info(u.toString());
		return u;
	}
		
	public List<User> findAll(){
		List<User> l = (List<User>)repo.findAll();
		l.forEach(u -> log.info(u.toString()));
		return l;
	}
}
