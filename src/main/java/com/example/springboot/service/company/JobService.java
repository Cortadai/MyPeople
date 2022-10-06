package com.example.springboot.service.company;

import java.util.List;
import java.util.Optional;

import com.example.springboot.dto.company.JobDTO;
import com.example.springboot.entity.company.Department;
import com.example.springboot.entity.company.Job;

public interface JobService {

	Optional<Job> findById(int id);
	
	List<Job> findAll();
	
	String borrarJob(int id);

	String crearTrabajo(JobDTO jobDto);
	
	Optional<Job> buscarUnTrabajo(String nomTrabajo);

}
