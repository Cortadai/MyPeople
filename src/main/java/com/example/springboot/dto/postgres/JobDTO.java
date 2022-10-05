package com.example.springboot.dto.postgres;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobDTO {

	private int job_id;
    private String job_title;
    private double min_salary;
    private double max_salary;
    
    
}
