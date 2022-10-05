package com.example.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.postgres.Location;
import com.example.springboot.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	private LocationRepository locationRepository;
	
	@Autowired
	public LocationServiceImpl(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	@Override
	public Optional<Location> findById(int id) {
		return locationRepository.findById(id);
	}

	@Override
	public List<Location> findAll() {
		return locationRepository.findAll();
	}

}
