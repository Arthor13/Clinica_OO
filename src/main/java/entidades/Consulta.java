package entidades;

import java.util.List;

public class Consulta {
  private String dataConsulta;
  private String horarioInicio;
  private int duracao;
  private String status;
  private Paciente paciente;
  private Medico medico;
  private List<Exame> examesPrescritos;
  private List<Medicamento> medicamentosPrescritos;
  private double Valor;


  public Consulta(String dataConsulta, String horarioInicio, int duracao, String status, Paciente paciente, Medico medico, List<Exame> examesPrescritos, List<Medicamento> medicamentosPrescritos, double valor) {
    this.dataConsulta = dataConsulta;
    this.horarioInicio = horarioInicio;
    this.duracao = duracao;
    this.status = status;
    this.paciente = paciente;
    this.medico = medico;
    this.examesPrescritos = examesPrescritos;
    this.medicamentosPrescritos = medicamentosPrescritos;
    Valor = valor;
  }

  public String getDataConsulta() {
    return dataConsulta;
  }
  
  public void setDataConsulta(String dataConsulta) {
    this.dataConsulta = dataConsulta;
  }

  public String getHorarioInicio() {
    return horarioInicio;
  } 

  public void setHorarioInicio(String horarioInicio) {
    this.horarioInicio = horarioInicio;
  }

  public int getDuracao() {
    return duracao;
  } 

  public void setDuracao(int duracao) {
    this.duracao = duracao;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
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

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
  

  public void agendarConsulta(){
    this.status = "Agendada";
  }

  public void cancelarConsulta(){
    this.status = "Cancelada";
  }

  public void realizarConsulta(){
    this.status = "Realizada";
  }

}