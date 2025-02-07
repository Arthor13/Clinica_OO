package servicos;

import entidades.Paciente;
import excecoes.PacienteJaExisteException;
import excecoes.PacienteNaoEncontradoException;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

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
        System.out.println("Paciente cadastrado com sucesso!");
    }

    public List<Paciente> listarPacientes() {
        return pacientes;
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
        System.out.println("Paciente atualizado com sucesso!");
    }

    public void removerPaciente(String cpf) throws PacienteNaoEncontradoException {
        Paciente pacienteRemovido = buscarPacientePorCpf(cpf);
        if (pacienteRemovido == null) {
            throw new PacienteNaoEncontradoException("Paciente não encontrado");
        }

        pacientes.remove(pacienteRemovido);
        System.out.println("Paciente removido com sucesso!");
    }
}
