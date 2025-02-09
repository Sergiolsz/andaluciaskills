package com.api.andaluciaskills.domain.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Especialidad {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idEspecialidad;

  private String nombre;
  private String codigo;

  @OneToMany(mappedBy = "especialidad", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Prueba> pruebas;
}