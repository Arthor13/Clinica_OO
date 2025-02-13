package menu;

import entidades.Paciente;
import excecoes.PacienteJaExisteException;
import excecoes.PacienteNaoEncontradoException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import servicos.ServicoPaciente;
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
                    break;
                case 2:
                    // Listar
                    listarPacientes();
                    break;
                case 3:
                    // Atualizar
                    atualizarPaciente();
                    break;
                case 4:
                    // Excluir
                    excluirPaciente();
                    break;
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

        String dataNascimentoStr = JOptionPane.showInputDialog("Data de Nascimento (dd/MM/yyyy)");
        LocalDate dataNascimento = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Data de Nascimento inválida");
            return;
        }

        Paciente paciente = new Paciente(nome, cpf, dataNascimento, telefone, email);
        try {
            servicoPaciente.cadastrarPaciente(paciente);
        } catch (PacienteJaExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
}

    public static void listarPacientes(){
        servicoPaciente.listarPacientes();
    }

    public static void atualizarPaciente(){
        String cpf = JOptionPane.showInputDialog("CPF");
        String nome = JOptionPane.showInputDialog("Nome");
        String telefone = JOptionPane.showInputDialog("Telefone");
        String email = JOptionPane.showInputDialog("Email");

        String dataNascimentoStr = JOptionPane.showInputDialog("Data de Nascimento (dd/MM/yyyy)");
        LocalDate dataNascimento = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Data de Nascimento inválida");
            return;
        }

        Paciente paciente = new Paciente(nome, cpf, dataNascimento, telefone, email);
        try {
            servicoPaciente.atualizarPaciente(cpf, paciente);
        } catch (PacienteNaoEncontradoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void excluirPaciente(){
        String cpf = JOptionPane.showInputDialog("CPF");
        try {
            servicoPaciente.removerPaciente(cpf);
        } catch (PacienteNaoEncontradoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}