package com.example.springboot.service.company;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.entity.company.Location;
import com.example.springboot.repository.company.LocationRepository;

@Transactional(transactionManager = "postgresTransactionManager")
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
