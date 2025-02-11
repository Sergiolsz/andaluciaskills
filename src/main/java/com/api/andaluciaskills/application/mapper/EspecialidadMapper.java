package com.api.andaluciaskills.application.mapper;

import com.api.andaluciaskills.application.dto.especialidad.EspecialidadDTO;
import com.api.andaluciaskills.domain.entities.Especialidad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EspecialidadMapper {

	EspecialidadMapper INSTANCE = Mappers.getMapper(EspecialidadMapper.class);

	EspecialidadDTO toDto(Especialidad especialidad);

	@Mapping(target = "codigo", ignore = true)
	@Mapping(target = "pruebas", ignore = true)
	Especialidad toEntity(EspecialidadDTO especialidadDTO);
}