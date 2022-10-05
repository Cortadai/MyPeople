package com.example.springboot.repository.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entity.postgres.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
	

}