package servicos;

import entidades.Medico;
import excecoes.MedicoJaExisteException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ServicoMedico {
    private List<Medico> medicos;

    public ServicoMedico() {
        this.medicos = new ArrayList<>();
    }

    public void cadastrarMedico(Medico medico) throws MedicoJaExisteException {
        if (buscarMedicoPorCrm(medico.getCrm()) != null) {
            throw new MedicoJaExisteException("Já existe um médico com esse CPF: " + medico.getCpf());
        }

        medicos.add(medico);
        JOptionPane.showMessageDialog(null, "Médico cadastrado com sucesso!");
    }

    public void listarMedicos() {
        for (Medico m : medicos) {
            JOptionPane.showMessageDialog(null, m);
        }
    }

    public Medico buscarMedicoPorCrm(int crm) {
        for (Medico m : medicos) {
            if (m.getCrm() == crm) {
                return m;
            }
        }
        return null;
    }

    public void atualizarMedico(int crm, Medico medico) {
        Medico medicoAtualizado = buscarMedicoPorCrm(crm);

        medicoAtualizado.setNome(medico.getNome());
        medicoAtualizado.setDataNascimento(medico.getDataNascimento());
        medicoAtualizado.setEspecialidade(medico.getEspecialidade());
        JOptionPane.showMessageDialog(null, "Médico atualizado com sucesso!");
    }

    public void removerMedico(int crm) {
        Medico medicoRemovido = buscarMedicoPorCrm(crm);

        medicos.remove(medicoRemovido);
        JOptionPane.showMessageDialog(null, "Médico removido com sucesso!");
    }
}