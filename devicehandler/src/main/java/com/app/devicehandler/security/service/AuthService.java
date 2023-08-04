package com.app.devicehandler.security.service;

import com.app.devicehandler.security.payload.LoginDto;
import com.app.devicehandler.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
