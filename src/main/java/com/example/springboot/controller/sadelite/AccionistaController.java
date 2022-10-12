package com.example.springboot.controller.sadelite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.ShareHolder;
import com.example.springboot.service.sadelite.HolderService;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;

@Api(tags = "Post Controller R")
@Tag(name = "Post Controller R", description = "Crud Rest Apis for Post Resources")
@RestController
@RequestMapping("/api/v1/accionistas")
public class AccionistaController {

	HolderService hosderService;
	
	@Autowired
	public AccionistaController(HolderService hosderService) {
		this.hosderService = hosderService;
	}

	// Mostrar todos los roles
	//@GetMapping("/all")
	//public ResponseEntity<List<Role>> buscarTodos() {
	//	return ResponseEntity.ok(roleService.buscarTodosRoles());
		// http://localhost:8080/api/v1/roles/all
	//}

	// Buscar un accionista por id
	@GetMapping("/buscarUno/{id}")
	public ResponseEntity<ShareHolder> buscarUno(@PathVariable Long id) {
		return ResponseEntity.ok(hosderService.buscarUno(id));
	}


}
