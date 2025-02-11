package com.api.andaluciaskills.application.dto.participante;

import lombok.Data;

@Data
public class CreateParticipanteDTO {

	private String dni;
	private String nombre;
	private String apellidos;
	private String email;
	private String centro;
	private Long especialidadId;
}