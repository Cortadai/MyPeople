package com.example.springboot.repository.company;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entity.company.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	

}
