package com.api.andaluciaskills.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Evaluacion {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idEvaluacion;

  @ManyToOne
  @JoinColumn(name = "Participante_idParticipante")
  private Participante participante;

  @ManyToOne
  @JoinColumn(name = "Prueba_idPrueba")
  private Prueba prueba;

  @ManyToOne
  @JoinColumn(name = "User_idUser")
  private Usuario evaluador;

  private Double notaFinal;
}