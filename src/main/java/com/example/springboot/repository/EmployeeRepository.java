package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entity.postgres.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	

}
