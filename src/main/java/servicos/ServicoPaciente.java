package servicos;

import entidades.Paciente;
import excecoes.PacienteJaExisteException;
import excecoes.PacienteNaoEncontradoException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ServicoPaciente {
    private List<Paciente> pacientes;

    public ServicoPaciente() {
        this.pacientes = new ArrayList<>();
    }

    public void cadastrarPaciente(Paciente paciente) throws PacienteJaExisteException {
        if (buscarPacientePorCpf(paciente.getCpf()) != null) {
            throw new PacienteJaExisteException("Já existe um paciente com esse CPF: " + paciente.getCpf());
        }

        pacientes.add(paciente);
        JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!");
    }

    public void listarPacientes() {
        for (Paciente p : pacientes) {
            JOptionPane.showMessageDialog(null, p);
        }
    }

    public Paciente buscarPacientePorCpf(String cpf) {
        for (Paciente p : pacientes) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }

    public void atualizarPaciente(String cpf, Paciente paciente) throws PacienteNaoEncontradoException {
        Paciente pacienteAtualizado = buscarPacientePorCpf(cpf);
        if (pacienteAtualizado == null) {
            throw new PacienteNaoEncontradoException("Paciente não encontrado");
        }

        pacienteAtualizado.setNome(paciente.getNome());
        pacienteAtualizado.setDataNascimento(paciente.getDataNascimento());
        pacienteAtualizado.setTelefone(paciente.getTelefone());
        pacienteAtualizado.setEmail(paciente.getEmail());
        JOptionPane.showMessageDialog(null, "Paciente atualizado com sucesso!");
    }

    public void removerPaciente(String cpf) throws PacienteNaoEncontradoException {
        Paciente pacienteRemovido = buscarPacientePorCpf(cpf);
        if (pacienteRemovido == null) {
            throw new PacienteNaoEncontradoException("Paciente não encontrado");
        }

        pacientes.remove(pacienteRemovido);
        JOptionPane.showMessageDialog(null, "Paciente removido com sucesso!");
    }
}
