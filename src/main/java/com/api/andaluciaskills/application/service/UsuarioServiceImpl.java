package com.api.andaluciaskills.application.service;

import com.api.andaluciaskills.domain.entities.Especialidad;
import com.api.andaluciaskills.domain.entities.Participante;
import com.api.andaluciaskills.domain.service.UsuarioService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

  /**
   * Esta impl es para los Usuarios Expertos.
   *
   * El experto puede:
   *
   * Ver su especialidad asignada.
   * Listar las especialidades.
   * Crear el participante (Al dar de alta al participante, se obtendrá su especialidad directamente del Experto)
   * Editar al participante
   * Listar los participantes
   *
   *
   */

  @Override
  public Especialidad getEspecialidad(Long id) {
    return null;
  }

  @Override
  public List<Especialidad> getAllEspecialidades() {
    return List.of();
  }

  @Override
  public Optional<Participante> getParticipanteById(Long id) {
    return Optional.empty();
  }

  @Override
  public List<Participante> getAllParticipantes() {
    return List.of();
  }

  @Override
  public Participante createParticipante(Participante participante) {
    return null;
  }

  @Override
  public Optional<Participante> updateParticipante(Long id, Participante participante) {
    return Optional.empty();
  }

}
