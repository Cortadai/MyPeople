package com.example.springboot.service;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dto.postgres.EmployeeDTO;
import com.example.springboot.entity.postgres.Department;
import com.example.springboot.entity.postgres.Employee;
import com.example.springboot.entity.postgres.Job;
import com.example.springboot.repository.DepartmentRepository;
import com.example.springboot.repository.EmployeeRepository;
import com.example.springboot.repository.JobRepository;
import com.example.springboot.utils.Constants;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	private JobRepository jobRepository;
	private DepartmentRepository departmentRepository;
	
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository,
							   JobRepository jobRepository,
							   DepartmentRepository departmentRepository) {
		this.employeeRepository = employeeRepository;
		this.jobRepository = jobRepository;
		this.departmentRepository = departmentRepository;
		
	}

	//Buscar uno por ID
	@Override
	public Optional<Employee> findById(int id) {
		return employeeRepository.findById(id);
	}

	//Listar Todos
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	//Borrar UNO POR ID
	@Override
	public String borrarEmpleado(int id) {
		if(!employeeRepository.existsById(id)) {
			Constants.message = "¡¡ El Empleado que solicitas NO Existe !!";
		}else {
			//Buscamos el Empleado que existe para borrarlo
			Employee existingEmployee = employeeRepository.findById(id).get();
			
			employeeRepository.delete(existingEmployee);
			Constants.message = "¡¡ El Empleado Ha sido BORRADO !!";
		}
		return Constants.message;
	}

	//Crear
	@Override
	public String crearEmpleado(EmployeeDTO employeeDto, String Trabajo, String Departamento) {
		//Para crear el Empleado, tenemos que verificar que el trabajo y el departamento existen, sino no se creará
		//si el findByName is present y el nombre de trabajo es el que le pasamos como variable en la url 
		if(buscarTrabajo(Trabajo) == false)  {
			Constants.message = "¡¡ El Trabajo: " + Trabajo + ", NO EXIXTE !! (El Empleado no se creará) ";
		}else {
			//busco el objeto trabajo que ya sé que existe
			Job trabajoExiste = jobRepository.findByName(Trabajo).get();
			
			//si el findByName is present y el nombre del departamento es el que le pasamos como variable en la url
			if(buscarDepartamento(Departamento) == false)  {
				Constants.message = "¡¡ El Departamento: " + Departamento + ", NO EXIXTE !! (El Empleado no se creará) ";
			}else {
				//busco el objeto del departamento que ya sé que existe
				Department departamentoExiste = departmentRepository.findByName(Departamento).get();
				
				Employee employee = new Employee();
				employee.setFirst_name(employeeDto.getFirst_name());
				employee.setLast_name(employeeDto.getLast_name());
				employee.setEmail(employeeDto.getEmail());
				employee.setPhone_number(employeeDto.getPhone_number());
				employee.setHire_date(employeeDto.getHire_date());
				employee.setSalary(employeeDto.getSalary());
				employee.setJobEmployee(trabajoExiste);
				employee.setDepEmployee(departamentoExiste);
				
				employeeRepository.save(employee);
			 
				Constants.message = "¡¡ Empleado Creado con Exito !!";
			}
		}
		return Constants.message;
	}
	
	//busca el Trabajo
	private boolean buscarTrabajo(String Trabajo) {
		if(!jobRepository.findByName(Trabajo).isPresent() || 
		   !jobRepository.findByName(Trabajo).get().getJob_title().equals(Trabajo)) {
			return false;
		} else {
			return true;
		}
	}
	//busca el Departamento
	private boolean buscarDepartamento(String Departamento) {
		if(!departmentRepository.findByName(Departamento).isPresent() || 
		   !departmentRepository.findByName(Departamento).get().getDepartment_name().equals(Departamento)) {
			return false;
		}else {
			return true;
		}
	}
	
	//Modificar
	@Override
	public String modificarEmpleado(EmployeeDTO employeeDto, int id, String Trabajo, String Departamento) {
		
		//busco al empleado que exista
		if (!employeeRepository.findById(id).isPresent()) {
			Constants.message = "¡¡ El Empleado No Existe, NO lo podemos Modificar !!";
		} else {
			if(buscarTrabajo(Trabajo) == false)  {
				Constants.message = "¡¡ El Trabajo: " + Trabajo + ", NO EXIXTE !! (El Empleado no se Modificará) ";
			}else {
				//busco el objeto trabajo que ya sé que existe
				Job trabajoExiste = jobRepository.findByName(Trabajo).get();
				
				//si el findByName is present y el nombre del departamento es el que le pasamos como variable en la url
				if(buscarDepartamento(Departamento) == false)  {
					Constants.message = "¡¡ El Departamento: " + Departamento + ", NO EXIXTE !! (El Empleado no se Modificará) ";
				}else {
					//busco el objeto del departamento que ya sé que existe
					Department departamentoExiste = departmentRepository.findByName(Departamento).get();
					//busco al empleado que existe para modificarlo
					Employee empleadoExiste = employeeRepository.findById(id).get();
					
					empleadoExiste.setFirst_name(employeeDto.getFirst_name());
					empleadoExiste.setLast_name(employeeDto.getLast_name());
					empleadoExiste.setEmail(employeeDto.getEmail());
					empleadoExiste.setPhone_number(employeeDto.getPhone_number());
					empleadoExiste.setHire_date(employeeDto.getHire_date());
					empleadoExiste.setSalary(employeeDto.getSalary());
					empleadoExiste.setJobEmployee(trabajoExiste);
					empleadoExiste.setDepEmployee(departamentoExiste);
					
					employeeRepository.save(empleadoExiste);
					 
					Constants.message = "¡¡ Empleado Modificado con Exito !!";
				}
			}
		}
		return Constants.message;
	}
	
}
