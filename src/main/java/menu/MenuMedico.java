package menu;

import entidades.Medico;
import excecoes.CpfInvalidoException;
import excecoes.CrmInvalidoException;
import excecoes.MedicoJaExisteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import servicos.ServicoMedico;

public class MenuMedico {
    static ServicoMedico servicoMedico = new ServicoMedico();

    public static void menuMedico() {
        int opcao = 0;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu Medico\n1 - Cadastrar\n2 - Listar\n3 - Atualizar\n4 - Excluir\n5- Exames\n6 - Voltar"));
            switch (opcao) {
                case 1:
                    // Cadastrar
                    cadastrarMedico();
                    break; // Adicione o break aqui
                case 2:
                    // Listar
                    listarMedico();
                    break; // Adicione o break aqui
                case 3:
                    // Atualizar
                    atualizarMedico();
                    break; // Adicione o break aqui
                case 4:
                    // Excluir
                    excluirMedico();
                    break; // Adicione o break aqui
                case 5:
                    // Exames
                    MenuExame.menuExame();
                    break; // Adicione o break aqui
                case 6:
                    // Voltar
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        } while (opcao != 5);
    }

    public static void cadastrarMedico() {
        String nome = JOptionPane.showInputDialog("Nome");
        String cpf = JOptionPane.showInputDialog("CPF (Deve conter 11 dígitos)");
        String dataNascimentoStr = JOptionPane.showInputDialog("Data de Nascimento (dd/MM/yyyy)");

        LocalDate dataNascimento = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Data de Nascimento inválida");
            return;
        }
        
        int crm = Integer.parseInt(JOptionPane.showInputDialog("CRM (Deve conter 4 dígitos)"));
        String especialidade = JOptionPane.showInputDialog("Especialidade");
        Medico medico;
        try {
            medico = new Medico(nome, cpf, dataNascimento, crm, especialidade);
        } catch (CrmInvalidoException | CpfInvalidoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return;
        }
        try {
            servicoMedico.cadastrarMedico(medico);
        } catch (MedicoJaExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void listarMedico() {
        servicoMedico.listarMedicos();
    }

    public static void atualizarMedico() {
        int crm = Integer.parseInt(JOptionPane.showInputDialog("CRM"));
        String nome = JOptionPane.showInputDialog("Nome");
        String cpf = JOptionPane.showInputDialog("CPF (Deve conter 11 dígitos)");
        
        String dataNascimentoStr = JOptionPane.showInputDialog("Data de Nascimento (dd/MM/yyyy)");

        LocalDate dataNascimento = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Data de Nascimento inválida");
            return;
        }

        String especialidade = JOptionPane.showInputDialog("Especialidade");
        Medico medico;
        try {
            medico = new Medico(nome, cpf, dataNascimento, crm, especialidade);
            servicoMedico.atualizarMedico(crm, medico);
        } catch (CrmInvalidoException | CpfInvalidoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void excluirMedico() {
        int crm = Integer.parseInt(JOptionPane.showInputDialog("CRM"));
        servicoMedico.removerMedico(crm);
    }
}
