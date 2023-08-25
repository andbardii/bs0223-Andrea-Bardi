package com.app.gestioneincendi.security.service;

import com.app.gestioneincendi.security.payload.LoginDto;
import com.app.gestioneincendi.security.payload.RegisterDto;
import com.app.gestioneincendi.security.payload.RegisterResponse;

public interface AuthService {
    
	String login(LoginDto loginDto);
	RegisterResponse register(RegisterDto registerDto);
    
}
