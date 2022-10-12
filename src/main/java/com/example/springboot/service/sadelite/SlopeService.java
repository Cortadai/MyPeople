package com.example.springboot.service.sadelite;

import java.util.List;

import com.example.springboot.dto.slope.SlopeDto;

public interface SlopeService {

	SlopeDto buscarUno(int id);
	
	List<SlopeDto> buscarTodosSlope();
	
	String insertSlope(SlopeDto slopeDto);
	
	String updateSloperOrigin(SlopeDto slopeDto);
	
	String deleteSlope(SlopeDto slopeDto);
}
