package model.entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Consulta {
  private LocalDate dataConsulta;
  private LocalTime horarioInicio;
  private int duracao;
  private StatusConsulta status;
  private entidades.Paciente paciente;
  private entidades.Medico medico;
  private List<entidades.Exame> examesPrescritos;
  private List<entidades.Medicamento> medicamentosPrescritos;
  private double valor;

  public Consulta(String dataConsulta, String horarioInicio, int duracao, String status,
                  entidades.Paciente paciente, entidades.Medico medico, List<entidades.Exame> examesPrescritos,
                  List<entidades.Medicamento> medicamentosPrescritos, double valor) {
    this.dataConsulta = LocalDate.parse(dataConsulta, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    this.horarioInicio = LocalTime.parse(horarioInicio, DateTimeFormatter.ofPattern("HH:mm"));
    this.duracao = duracao;
    this.status = StatusConsulta.valueOf(status.toUpperCase());
    this.paciente = paciente;
    this.medico = medico;
    this.examesPrescritos = (examesPrescritos != null) ? examesPrescritos : new ArrayList<>();
    this.medicamentosPrescritos = (medicamentosPrescritos != null) ? medicamentosPrescritos : new ArrayList<>();
    this.valor = valor;
  }

  // Getters and Setters...
}
