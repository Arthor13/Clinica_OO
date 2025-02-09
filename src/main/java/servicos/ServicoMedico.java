package servicos;

import entidades.Medico;
import excecoes.MedicoJaExisteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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
        System.out.println("Médico cadastrado com sucesso!");
    }

    public List<Medico> listarMedicos() {
        return medicos;
    }

    public Medico buscarMedicoPorCrm(int crm) {
        for (Medico m : medicos) {
            if (m.getCrm() == crm) {
                return m;
            }
        }
        return null;
    }

    public void atualizarPaciente(String nome, LocalDate dataNascimento,int crm, String especialidade, Medico medico) {
        Medico medicoAtualizado = buscarMedicoPorCrm(crm);

        medicoAtualizado.setNome(nome);
        medicoAtualizado.setDataNascimento(dataNascimento);
        medicoAtualizado.setCrm(crm);
        medicoAtualizado.setEspecialidade(especialidade);
        System.out.println("Médico atualizado com sucesso!");
    }

    public void removerMedico(int crm) {
        Medico medicoRemovido = buscarMedicoPorCrm(crm);

        medicos.remove(medicoRemovido);
        System.out.println("Médico removido com sucesso!");
    }
}