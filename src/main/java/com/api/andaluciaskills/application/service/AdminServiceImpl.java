package com.api.andaluciaskills.application.service;

import com.api.andaluciaskills.domain.entities.Especialidad;
import com.api.andaluciaskills.domain.entities.Usuario;
import com.api.andaluciaskills.domain.service.AdminService;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

  @Override
  @Transactional
  public String createExperto(Usuario usuario) {
    return "";
  }

  @Override
  @Transactional
  public String createEspecialidad(Especialidad especialidad) {
    return "";
  }

  @Override
  @Transactional
  public Especialidad editEspecialidad(Especialidad especialidad) {
    return null;
  }

  @Override
  public List<Especialidad> listEspecialidades() {
    return List.of();
  }
}
