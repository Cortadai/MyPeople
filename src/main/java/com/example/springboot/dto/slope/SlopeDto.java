package com.example.springboot.dto.slope;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SlopeDto {
	
	private Integer codSlope;
	private Double minValue;
	private Double maxValue;
	private String origin;
}


