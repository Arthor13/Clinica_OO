package model.menu;

import javax.swing.JOptionPane;
import entidades.Medico;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import servicos.ServicoMedico;
import excecoes.MedicoJaExisteException;
import java.util.List;

public class MenuMedico {
    static ServicoMedico servicoMedico = new ServicoMedico();

    public static void menuMedico() {
        int opcao = 0;
        do {
            try {
                String entrada = JOptionPane.showInputDialog(
                        "Menu Médico\n1 - Cadastrar\n2 - Listar\n3 - Atualizar\n4 - Excluir\n5 - Voltar");

                if (entrada == null) return; // Usuário cancelou

                opcao = Integer.parseInt(entrada);
                switch (opcao) {
                    case 1:
                        cadastrarMedico();
                        break;
                    case 2:
                        listarMedico();
                        break;
                    case 3:
                        atualizarMedico();
                        break;
                    case 4:
                        excluirMedico();
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Voltando ao menu principal...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite um número válido!");
            }
        } while (opcao != 5);
    }

    public static void cadastrarMedico() {
        String nome = JOptionPane.showInputDialog("Nome");
        if (nome == null || nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome inválido!");
            return;
        }

        String cpf = JOptionPane.showInputDialog("CPF");
        if (cpf == null || cpf.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CPF inválido!");
            return;
        }

        String dataNascimentoStr = JOptionPane.showInputDialog("Data de Nascimento (dd/MM/yyyy)");
        LocalDate dataNascimento = converterData(dataNascimentoStr);
        if (dataNascimento == null) {
            JOptionPane.showMessageDialog(null, "Data inválida! Use o formato dd/MM/yyyy.");
            return;
        }

        int crm;
        try {
            crm = Integer.parseInt(JOptionPane.showInputDialog("CRM"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "CRM inválido! Digite um número.");
            return;
        }

        String especialidade = JOptionPane.showInputDialog("Especialidade");
        if (especialidade == null || especialidade.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Especialidade inválida!");
            return;
        }

        Medico medico = new Medico(nome, cpf, dataNascimento, crm, especialidade);
        try {
            servicoMedico.cadastrarMedico(medico);
            JOptionPane.showMessageDialog(null, "Médico cadastrado com sucesso!");
        } catch (MedicoJaExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void listarMedico() {
        List<Medico> medicos = servicoMedico.listarMedicos();
        if (medicos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum médico cadastrado.");
            return;
        }

        StringBuilder lista = new StringBuilder("Lista de Médicos:\n");
        for (Medico medico : medicos) {
            lista.append(medico.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, lista.toString());
    }

    public static void atualizarMedico() {
        int crm;
        try {
            crm = Integer.parseInt(JOptionPane.showInputDialog("CRM"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "CRM inválido! Digite um número.");
            return;
        }

        String nome = JOptionPane.showInputDialog("Nome");
        if (nome == null || nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome inválido!");
            return;
        }

        String cpf = JOptionPane.showInputDialog("CPF");
        if (cpf == null || cpf.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CPF inválido!");
            return;
        }

        String dataNascimentoStr = JOptionPane.showInputDialog("Data de Nascimento (dd/MM/yyyy)");
        LocalDate dataNascimento = converterData(dataNascimentoStr);
        if (dataNascimento == null) {
            JOptionPane.showMessageDialog(null, "Data inválida! Use o formato dd/MM/yyyy.");
            return;
        }

        String especialidade = JOptionPane.showInputDialog("Especialidade");
        if (especialidade == null || especialidade.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Especialidade inválida!");
            return;
        }

        Medico medico = new Medico(nome, cpf, dataNascimento, crm, especialidade);
        servicoMedico.atualizarMedico(crm, medico);
        JOptionPane.showMessageDialog(null, "Médico atualizado com sucesso!");
    }

    public static void excluirMedico() {
        try {
            int crm = Integer.parseInt(JOptionPane.showInputDialog("CRM"));
            servicoMedico.removerMedico(crm);
            JOptionPane.showMessageDialog(null, "Médico removido com sucesso!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "CRM inválido! Digite um número.");
        }
    }

    private static LocalDate converterData(String dataStr) {
        if (dataStr == null || dataStr.trim().isEmpty()) {
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(dataStr.trim(), formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}
