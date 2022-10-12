package com.example.springboot.controller.sadelite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.dto.slope.SlopeDto;
import com.example.springboot.service.sadelite.SlopeService;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;

@Api(tags = "Slope Controller R")
@Tag(name = "Slope Controller R", description = "Crud Rest Apis for Sloper Resources")
@RestController
@RequestMapping("/api/v1/slope")
public class SlopeController {

	SlopeService slopeService;
	
	@Autowired
	public SlopeController(SlopeService slopeService) {
		this.slopeService = slopeService;
	}

	// Mostrar todos los slopes
	@GetMapping("/buscarTodos")
	public ResponseEntity<List<SlopeDto>> buscarTodosSlopers() {
		return ResponseEntity.ok(slopeService.buscarTodosSlope());
	}

	// Buscar un slope por id
	@GetMapping("/buscarUno/{id}")
	public ResponseEntity<SlopeDto> buscarUno(@PathVariable int id) {
		return ResponseEntity.ok(slopeService.buscarUno(id));
	}
	
	//insertar un nuevo Sloper
	@PostMapping("crearSloper")
	public ResponseEntity<String> crearSlope(@RequestBody SlopeDto slopeDto) {
		return ResponseEntity.ok(slopeService.insertSlope(slopeDto));
	}
	
	//Modificar el Origin de un Sloper
	@PostMapping("modificarSloper")
	public ResponseEntity<String> modificarSlope(@RequestBody SlopeDto slopeDto) {
		return ResponseEntity.ok(slopeService.updateSloperOrigin(slopeDto));
	}
	
	//Eliminar un Sloper por ID
	@DeleteMapping("eliminarSloper")
	public ResponseEntity<String> eliminarSlope(@RequestBody SlopeDto slopeDto) {
		return ResponseEntity.ok(slopeService.deleteSlope(slopeDto));
	}
	


}
