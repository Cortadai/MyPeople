package com.example.springboot.service.company;

import java.util.List;
import java.util.Optional;

import com.example.springboot.entity.company.Location;

public interface LocationService {

	Optional<Location> findById(int id);
	
	List<Location> findAll();

}
