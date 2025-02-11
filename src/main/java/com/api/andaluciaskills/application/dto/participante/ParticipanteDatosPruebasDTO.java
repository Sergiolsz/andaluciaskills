package com.api.andaluciaskills.application.dto.participante;

import com.api.andaluciaskills.application.dto.prueba.PruebaDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipanteDatosPruebasDTO {

	private String dni;
	private String nombre;
	private String apellidos;
	private String email;
	private String especialidad;
	private List<PruebaDTO> pruebas;
	private int puntuacionTotal;
}
