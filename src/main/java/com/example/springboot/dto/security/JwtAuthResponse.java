

package com.example.springboot.dto.security;

import lombok.Data;

@Data
public class JwtAuthResponse {
	
	private String accessToken;
	private String tokenType = "Bearer";
	
	public JwtAuthResponse (String accessToken) {
		this.accessToken = accessToken;
	}

}
