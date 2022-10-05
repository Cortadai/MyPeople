package com.example.springboot.service;

import java.util.List;
import java.util.Optional;

import com.example.springboot.entity.postgres.Location;

public interface LocationService {

	Optional<Location> findById(int id);
	
	List<Location> findAll();

}
