package entidades;

import java.util.ArrayList;
import java.util.List;

public class HistoricoMedico {
    private List<Consulta> consultas;
    private List<Exame> exames;

    public HistoricoMedico() {
        this.consultas = new ArrayList<>();
        this.exames = new ArrayList<>();
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void adicionarConsulta(Consulta consulta) {
        this.consultas.add(consulta);
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void adicionarExame(Exame exame) {
        this.exames.add(exame);
    }

    public String toString() {
        String historico = "Consultas:\n";
        for (Consulta consulta : consultas) {
            historico += consulta + "\n";
        }
        historico += "Exames:\n";
        for (Exame exame : exames) {
            historico += exame + "\n";
        }
        return historico;
    }
}