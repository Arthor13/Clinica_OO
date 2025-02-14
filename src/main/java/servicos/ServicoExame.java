package servicos;

import  entidades.Exame;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ServicoExame {

    private List<Exame> exames;

    public ServicoExame() {
        this.exames = new ArrayList<>();
    }

    public void cadastrarExame(String tipo, LocalDate dataPrescricao, Double custo  ) {
        Exame exame = new Exame(tipo, dataPrescricao, custo);
        exames.add(exame);
        JOptionPane.showMessageDialog(null, "Exame cadastrado com sucesso!");
    }

    public List<Exame> listarExames() {
        return exames;
    }

    /// Método para buscar um exame pelo, pensar em outra forma de fazer isso
    public Exame buscarExameporId(int id) {
        for (Exame e : exames) {
            if (e.getId() == id) { 
                return e;
            }
        }
        return null;
    }

    public void atualizarExame(int id, Exame exame) {
        Exame exameAtualizado = buscarExameporId(id);
        if (exameAtualizado != null) {
            exameAtualizado.setTipo(exame.getTipo());
            exameAtualizado.setCusto(exame.getCusto());
            exameAtualizado.setDataPrescricao(exame.getDataPrescricao());
            JOptionPane.showMessageDialog(null, "Exame atualizado com sucesso!");
        } 
    }

    public void removerExame(Exame exame) {
        if (exame != null) {
            exames.remove(exame);
            JOptionPane.showMessageDialog(null, "Exame removido com sucesso!");
        } 
    }
}
