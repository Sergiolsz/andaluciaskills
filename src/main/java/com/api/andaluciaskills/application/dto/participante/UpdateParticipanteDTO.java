package com.api.andaluciaskills.application.dto.participante;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateParticipanteDTO {

	private String nombre;
	private String apellidos;
	private String email;
}