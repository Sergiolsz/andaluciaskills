package com.api.andaluciaskills.domain.service;

import com.api.andaluciaskills.domain.entities.Especialidad;
import com.api.andaluciaskills.domain.entities.Usuario;
import java.util.List;

public interface AdminService {

  String createExperto(Usuario usuario);

  String createEspecialidad(Especialidad especialidad);

  Especialidad editEspecialidad(Especialidad especialidad);

  List<Especialidad> listEspecialidades();
}
