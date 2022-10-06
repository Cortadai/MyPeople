package com.example.springboot.controller.company;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.dto.company.EmployeeDTO;
import com.example.springboot.entity.company.Employee;
import com.example.springboot.resource.EmailBody;
import com.example.springboot.service.company.EmployeeService;
import com.example.springboot.service.email.EmailService;
import com.example.springboot.utils.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Api(tags="Employee Controller") //anotacion para documentar con Swagger
@Tag(name = "Employee Controller", description = "CRUD de Empleados de APP MyPeople")
@RestController
@RequestMapping("/api/v1/empleados")
public class EmployeeController {

	private EmployeeService employeeService;
	private EmailService emailService;

	@Autowired
	public EmployeeController(EmployeeService employeeService, EmailService emailService) {
		this.employeeService = employeeService;
		this.emailService = emailService;
	}
	
	//Listar Empleados por ID
	@ApiOperation(value="Ver Datos de un Empleado buscado por ID") //anotacion para documentar con Swagger
	@GetMapping("/verEmpleado/{id}")
	public ResponseEntity<Optional<Employee>> buscaEmpleado(@PathVariable("id") int id) {
		return ResponseEntity.ok(employeeService.findById(id));
	}
	
	
	
	//Listar todos los Empleados
	@ApiOperation(value="Listar Todos los Empleados") //anotacion para documentar con Swagger
	@GetMapping("/listaEmpleados")
	public ResponseEntity<List<Employee>> listarEmpleados() {
		return ResponseEntity.ok(employeeService.findAll());
	}
	
	//Creamos un Empleado, 
	//devolvemos el Usuario desde el servicio
	@ApiOperation(value="Crear Empleados") //anotacion para documentar con Swagger
	@PostMapping("/crearEmpleado/{Qtrabajo}/{Qdepartamento}")
	public ResponseEntity<String> crearEmpleado(@RequestBody EmployeeDTO employeeDto, 
								@PathVariable("Qtrabajo") String QueTrabajo, 
								@PathVariable("Qdepartamento") String QueDepartamento) {

		return ResponseEntity.ok(employeeService.crearEmpleado(employeeDto, QueTrabajo, QueDepartamento));
	}
	
	//Modificamos un Empleado, 
	//devolvemos el Usuario desde el servicio
	@ApiOperation(value="Modificar Empleados") //anotacion para documentar con Swagger
	@PutMapping("/modificaEmpleado/{idEmpleado}/{Qtrabajo}/{Qdepartamento}")
	public ResponseEntity<String> modificaEmpleado(@RequestBody EmployeeDTO employeeDto,
								@PathVariable("idEmpleado") int id,
								@PathVariable("Qtrabajo") String QueTrabajo, 
								@PathVariable("Qdepartamento") String QueDepartamento) {
		
		return ResponseEntity.ok(employeeService.modificarEmpleado(employeeDto, id, QueTrabajo, QueDepartamento));
	}
	
	//Eliminar un Empleado, 
	//devolvemos el Usuario desde el servicio
	@ApiOperation(value="Eliminar Empleados") //anotacion para documentar con Swagger
	@DeleteMapping("/borraEmpleado/{idEmpleado}")
	public ResponseEntity<String> borrarEmpleado(@PathVariable("idEmpleado") int id) {

		return ResponseEntity.ok(employeeService.borrarEmpleado(id));
	}
	
}
