package com.example.springboot.entity.postgres;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table( name = "departments", schema = "my_people")
public class Department {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int department_id; 			   //SERIAL PRIMARY KEY,
	
	@Column(name = "department_name", length = 30, nullable = false)
    private String department_name; 		//CHARACTER VARYING(30) NOT NULL,
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id", referencedColumnName = "location_id")
    private Location LocDepartment;
}

/*CREATE TABLE departments
(
    department_id   SERIAL PRIMARY KEY,
    department_name CHARACTER VARYING(30) NOT NULL,
    location_id     INTEGER,
    FOREIGN KEY (location_id) REFERENCES locations (location_id) ON UPDATE CASCADE ON DELETE CASCADE
);
*/