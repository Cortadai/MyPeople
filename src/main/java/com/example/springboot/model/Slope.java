package com.example.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Slope {
	
	private Integer codSlope;
	private Double minValue;
	private Double maxValue;
	private String origin;
}
