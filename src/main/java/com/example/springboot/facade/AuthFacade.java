
package com.example.springboot.facade;

import org.springframework.http.ResponseEntity;

import com.example.springboot.dto.security.JwtAuthResponse;
import com.example.springboot.dto.security.LoginDto;

public interface AuthFacade {
	
	ResponseEntity<JwtAuthResponse> authenticateUser(LoginDto loginDto);

}
