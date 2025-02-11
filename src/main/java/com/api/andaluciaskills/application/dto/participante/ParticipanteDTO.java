package com.api.andaluciaskills.application.dto.participante;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipanteDTO {

	private String dni;
	private String nombre;
	private String apellidos;
	private String email;
	private String centro;

	private String especialidad;
}