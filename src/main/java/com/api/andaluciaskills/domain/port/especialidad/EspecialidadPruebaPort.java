package com.api.andaluciaskills.domain.port.especialidad;

import com.api.andaluciaskills.domain.entities.Prueba;
import java.util.List;

public interface EspecialidadPruebaPort {

	List<Prueba> findPruebasByParticipanteDni(String dni);
}