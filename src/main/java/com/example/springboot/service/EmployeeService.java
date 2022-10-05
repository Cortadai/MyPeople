package com.example.springboot.service;

import java.util.List;
import java.util.Optional;

import com.example.springboot.dto.postgres.EmployeeDTO;
import com.example.springboot.entity.postgres.Employee;

public interface EmployeeService {

	Optional<Employee> findById(int id);
	
	List<Employee> findAll();
	
	String borrarEmpleado(int id);
	
	String crearEmpleado(EmployeeDTO employeeDto, String Trabajo, String Departamento);

	String modificarEmpleado(EmployeeDTO employeeDto, int id, String Trabajo, String Departamento);
}
