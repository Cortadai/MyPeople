package com.example.springboot.service.company;

import java.util.List;
import java.util.Optional;

import com.example.springboot.entity.company.Department;

public interface DepartmentService {
	
	Optional<Department> findById(int id);
	
	List<Department> findAll();
	
	Optional<Department> buscarUnDepartamento(String nomDepartamento);

}
