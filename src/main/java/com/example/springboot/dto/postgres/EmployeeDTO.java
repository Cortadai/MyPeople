package com.example.springboot.dto.postgres;

import java.util.Date;

import com.example.springboot.entity.postgres.Department;
import com.example.springboot.entity.postgres.Job;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDTO {


    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private Date hire_date;
    private double salary;
    
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "job_id", referencedColumnName = "job_id")
    private Job jobEmployee;
	
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "department_id", referencedColumnName = "department_id")
    private Department depEmployee;
}
