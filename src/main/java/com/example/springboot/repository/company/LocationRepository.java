package com.example.springboot.repository.company;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entity.company.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
	

}
