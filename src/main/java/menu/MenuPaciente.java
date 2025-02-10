package menu;

import javax.swing.JOptionPane;
import entidades.Paciente;
import java.time.LocalDate;
import servicos.ServicoPaciente;
import excecoes.PacienteJaExisteException;


public class MenuPaciente {
    static ServicoPaciente servicoPaciente = new ServicoPaciente();

    public static void menuPaciente() {
        int opcao = 0;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu Paciente\n1 - Cadastrar\n2 - Listar\n3 - Atualizar\n4 - Excluir\n5 - Voltar"));
            switch (opcao) {
                case 1:
                    // Cadastrar
                    cadastrarPaciente();
                case 2:
                    // Listar
                    listarPacientes();
                case 3:
                    // Atualizar
                    atualizarPaciente();
                case 4:
                    // Excluir
                    excluirPaciente();
                case 5:
                    // Voltar
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        } while (opcao != 5);
    }


    public static void cadastrarPaciente() {
        String nome = JOptionPane.showInputDialog("Nome");
        String cpf = JOptionPane.showInputDialog("CPF");
        String telefone = JOptionPane.showInputDialog("Telefone");
        String email = JOptionPane.showInputDialog("Email");
        String dataNascimento = JOptionPane.showInputDialog("Data de Nascimento");
        Paciente paciente = new Paciente(nome, cpf, dataNascimento, telefone, email);
        try {
            servicoPaciente.cadastrarPaciente(paciente);
        } catch (PacienteJaExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void listarPacientes() {
        servicoPaciente.listarPacientes();
    }

    public static void atualizarPaciente() {
        String cpf = JOptionPane.showInputDialog("CPF");
        String nome = JOptionPane.showInputDialog("Nome");
        String telefone = JOptionPane.showInputDialog("Telefone");
        String email = JOptionPane.showInputDialog("Email");
        String dataNascimento = JOptionPane.showInputDialog("Data de Nascimento");

        Paciente paciente = new Paciente(nome, cpf, dataNascimento, telefone, email);
        try {
            servicoPaciente.atualizarPaciente(cpf, paciente);
            JOptionPane.showInputDialog(null,"Paciente atualizado com sucesso!");
        } catch (excecoes.PacienteNaoEncontradoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void excluirPaciente() {
        String cpf = JOptionPane.showInputDialog("CPF");
        try {
            servicoPaciente.removerPaciente(cpf);
            JOptionPane.showMessageDialog(null, "Paciente removido com sucesso!");
        } catch (excecoes.PacienteNaoEncontradoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}