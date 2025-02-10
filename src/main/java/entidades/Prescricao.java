package model.entidades;


import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import entidades.Medicamento;
import entidades.Exame;
import model.entidades.Consulta;

public class Prescricao {
    private int id;
    private List<Medicamento> medicamento;
    private List<Exame> exame;
    private Consulta consultaAssociada;
    private LocalDate dataValidade;

    public Prescricao(int id, List<Medicamento> medicamento, List<Exame> exame, Consulta consultaAssociada, LocalDate dataValidade) {
        this.id = id;
        this.medicamento = (medicamento != null) ? medicamento : new ArrayList<>();
        this.exame = (exame != null) ? exame : new ArrayList<>();
        this.consultaAssociada = consultaAssociada;
        this.dataValidade = dataValidade;
    }

    public void setMedicamento(List<Medicamento> medicamento) {
        this.medicamento = medicamento;
    }

    public List<Medicamento> getMedicamento() {
        return medicamento;
    }

    public void setExame(List<Exame> exame) {
        this.exame = exame;
    }

    public List<Exame> getExame() {
        return exame;
    }

    public void setConsultaAssociada(Consulta consultaAssociada) {
        this.consultaAssociada = consultaAssociada;
    }

    public Consulta getConsultaAssociada() {
        return consultaAssociada;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }
}
