package com.api.andaluciaskills.infraestructure.controller;

import com.api.andaluciaskills.application.dto.especialidad.EspecialidadDTO;
import com.api.andaluciaskills.domain.service.EspecialidadService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/especialidades")
@PreAuthorize("hasRole('ROLE_EXPERTO')")
public class EspecialidadController {

	private final EspecialidadService especialidadService;

	public EspecialidadController(EspecialidadService especialidadService) {

		this.especialidadService = especialidadService;
	}

	@GetMapping
	public ResponseEntity<List<EspecialidadDTO>> getAllEspecialidades() {

		return ResponseEntity.ok(especialidadService.getAllEspecialidades());
	}

	@GetMapping("/{id}")
	public ResponseEntity<EspecialidadDTO> getEspecialidadById(@PathVariable Long id) {

		return ResponseEntity.ok(especialidadService.getEspecialidadById(id));
	}
}