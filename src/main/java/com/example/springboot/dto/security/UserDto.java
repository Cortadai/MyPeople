package com.example.springboot.dto.security;

import java.util.Set;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "User model information")
public class UserDto {
	
	@ApiModelProperty(value = "UserDto id")
	private Long id;
	@ApiModelProperty(value = "UserDto name")
	private String name;
	@ApiModelProperty(value = "UserDto email")
	private String email;
	@ApiModelProperty(value = "UserDto password")
	private String password;
	@ApiModelProperty(value = "UserDto active")
	private boolean active;
	
	
	
	
	
}

