package servicos;

import  entidades.Exame;
import java.util.ArrayList;
import java.util.List;

public class ServicoExame {

    private List<Exame> exames;

    public ServicoExame() {
        this.exames = new ArrayList<>();
    }

    public void cadastrarExame(Exame exame) {
        exames.add(exame);
        System.out.println("Exame cadastrado com sucesso!");
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
            System.out.println("Exame atualizado com sucesso!");
        } 
    }

    public void removerExame(int id) {
        Exame exame = buscarExameporId(id);
        if (exame != null) {
            exames.remove(exame);
            System.out.println("Exame removido com sucesso!");
        } 
    }
}
