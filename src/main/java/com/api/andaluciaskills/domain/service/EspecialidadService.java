package com.api.andaluciaskills.domain.service;

import com.api.andaluciaskills.application.dto.especialidad.EspecialidadDTO;
import java.util.List;

public interface EspecialidadService {

	List<EspecialidadDTO> getAllEspecialidades();

	EspecialidadDTO getEspecialidadById(Long id);
}