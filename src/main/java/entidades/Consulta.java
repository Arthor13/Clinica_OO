package entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import entidades.Medicamento;
import entidades.StatusConsulta;
import entidades.Exame;
import entidades.Medico;
import entidades.Paciente;

public class Consulta {
  private LocalDate dataConsulta;
  private LocalTime horarioInicio;
  private int duracao;
  private StatusConsulta status;
  private Paciente paciente;
  private Medico medico;
  private List<Exame> examesPrescritos;
  private List<Medicamento> medicamentosPrescritos;
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

  public LocalDate getDataConsulta() {
    return dataConsulta;
  }

  public void setDataConsulta(LocalDate dataConsulta) {
    this.dataConsulta = dataConsulta;
  }

  public LocalTime getHorarioInicio() {
    return horarioInicio;
  }

  public void setHorarioInicio(LocalTime horarioInicio) {
    this.horarioInicio = horarioInicio;
  }

  public int getDuracao() {
    return duracao;
  }

  public void setDuracao(int duracao) {
    this.duracao = duracao;
  }

  public StatusConsulta getStatus() {
    return status;
  }

  public void setStatus(StatusConsulta status) {
    this.status = status;
  }

  public entidades.Paciente getPaciente() {
    return paciente;
  }

  public void setPaciente(entidades.Paciente paciente) {
    this.paciente = paciente;
  }

  public entidades.Medico getMedico() {
    return medico;
  }

  public void setMedico(entidades.Medico medico) {
    this.medico = medico;
  }

  public List<entidades.Exame> getExamesPrescritos() {
    return examesPrescritos;
  }

  public void setExamesPrescritos(List<entidades.Exame> examesPrescritos) {
    this.examesPrescritos = examesPrescritos;
  }

  public List<entidades.Medicamento> getMedicamentosPrescritos() {
    return medicamentosPrescritos;
  }

  public void setMedicamentosPrescritos(List<entidades.Medicamento> medicamentosPrescritos) {
    this.medicamentosPrescritos = medicamentosPrescritos;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }
}
