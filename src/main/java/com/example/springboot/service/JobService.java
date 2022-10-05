package com.example.springboot.service;

import java.util.List;
import java.util.Optional;

import com.example.springboot.dto.postgres.JobDTO;
import com.example.springboot.entity.postgres.Department;
import com.example.springboot.entity.postgres.Job;

public interface JobService {

	Optional<Job> findById(int id);
	
	List<Job> findAll();
	
	String borrarJob(int id);

	String crearTrabajo(JobDTO jobDto);
	
	Optional<Job> buscarUnTrabajo(String nomTrabajo);

}
