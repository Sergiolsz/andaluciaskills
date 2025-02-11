package com.api.andaluciaskills.application.mapper;

import com.api.andaluciaskills.application.dto.participante.CreateParticipanteDTO;
import com.api.andaluciaskills.application.dto.participante.ParticipanteDTO;
import com.api.andaluciaskills.domain.entities.Participante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ParticipanteMapper {

	ParticipanteMapper INSTANCE = Mappers.getMapper(ParticipanteMapper.class);

	@Mapping(source = "especialidad.nombre", target = "especialidad")
	ParticipanteDTO toDto(Participante participante);

	@Mapping(target = "especialidad", ignore = true)
	Participante toEntity(CreateParticipanteDTO dto);
}