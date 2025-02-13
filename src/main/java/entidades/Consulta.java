package entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
                  Paciente paciente, Medico medico, List<Exame> examesPrescritos,
                  List<Medicamento> medicamentosPrescritos, double valor) {
    this.dataConsulta = LocalDate.parse(dataConsulta, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    this.horarioInicio = LocalTime.parse(horarioInicio, DateTimeFormatter.ofPattern("HH:mm"));
    this.duracao = duracao;
    this.status = StatusConsulta.valueOf(status.toUpperCase());
    this.paciente = paciente;
    this.medico = medico;
    this.examesPrescritos = examesPrescritos; // Permitir nulo
    this.medicamentosPrescritos = medicamentosPrescritos; // Permitir nulo
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

  public Paciente getPaciente() {
    return paciente;
  }

  public void setPaciente(Paciente paciente) {
    this.paciente = paciente;
  }

  public Medico getMedico() {
    return medico;
  }

  public void setMedico(Medico medico) {
    this.medico = medico;
  }

  public List<Exame> getExamesPrescritos() {
    return examesPrescritos;
  }

  public void setExamesPrescritos(List<Exame> examesPrescritos) {
    this.examesPrescritos = examesPrescritos;
  }

  public List<Medicamento> getMedicamentosPrescritos() {
    return medicamentosPrescritos;
  }

  public void setMedicamentosPrescritos(List<Medicamento> medicamentosPrescritos) {
    this.medicamentosPrescritos = medicamentosPrescritos;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public String toString() {
    return "Consulta{" +
            "dataConsulta=" + dataConsulta +
            ", horarioInicio=" + horarioInicio +
            ", duracao=" + duracao +
            ", status=" + status +
            ", paciente=" + paciente +
            ", medico=" + medico +
            ", examesPrescritos=" + examesPrescritos +
            ", medicamentosPrescritos=" + medicamentosPrescritos +
            ", valor=" + valor +
            '}';
  }
}
