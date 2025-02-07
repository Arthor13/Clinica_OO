import servicos.ServicoPaciente;
import entidades.Paciente;
import excecoes.PacienteJaExisteException;
import excecoes.PacienteNaoEncontradoException;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ServicoPaciente servicoPaciente = new ServicoPaciente();

        try {
            // Criando pacientes
            servicoPaciente.cadastrarPaciente("Carlos Silva", "123.456.789-00", LocalDate.of(1990, 5, 10));
            servicoPaciente.cadastrarPaciente("Mariana Souza", "987.654.321-00", LocalDate.of(1985, 8, 22));

            // Listando pacientes
            System.out.println("\n📋 Lista de Pacientes:");
            List<Paciente> pacientes = servicoPaciente.listarPacientes();
            for (Paciente p : pacientes) {
                System.out.println(p);
            }

            // Atualizando paciente
            System.out.println("\n✏️ Atualizando paciente...");
            servicoPaciente.atualizarPaciente("123.456.789-00", "Carlos A. Silva", LocalDate.of(1990, 5, 10));

            // Removendo paciente
            System.out.println("\n🗑️ Removendo paciente...");
            servicoPaciente.removerPaciente("987.654.321-00");

            // Tentando buscar paciente removido
            System.out.println("\n🔎 Buscando paciente removido...");
            servicoPaciente.buscarPacientePorCpf("987.654.321-00");

        } catch (PacienteJaExisteException | PacienteNaoEncontradoException e) {
            System.out.println("❌ Erro: " + e.getMessage());
        }
    }
}
