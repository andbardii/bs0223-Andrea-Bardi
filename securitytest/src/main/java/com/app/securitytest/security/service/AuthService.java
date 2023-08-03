package com.app.securitytest.security.service;

import com.app.securitytest.security.payload.LoginDto;
import com.app.securitytest.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
