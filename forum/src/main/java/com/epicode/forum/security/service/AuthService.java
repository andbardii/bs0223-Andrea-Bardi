package com.epicode.forum.security.service;

import com.epicode.forum.security.payload.LoginDto;
import com.epicode.forum.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
