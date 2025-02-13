package menu;

import entidades.Consulta;
import excecoes.ConsultaJaExisteException;
import excecoes.ConsultaNaoEncontradaException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import servicos.ServicoConsulta;
import servicos.ServicoExame;
import servicos.ServicoMedico;
import servicos.ServicoPaciente;

public class MenuConsulta {
    static ServicoPaciente servicoPaciente = new ServicoPaciente();
    static ServicoMedico servicoMedico = new ServicoMedico();
    static ServicoConsulta servicoConsulta = new ServicoConsulta();
    static ServicoExame servicoExame = new ServicoExame();

    public static void menuConsulta() {
        int opcao = 0;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu Consulta\n1 - Agendar\n2 - Listar\n3 - Atualizar\n4 - Cancelar\n5 - Voltar"));
            switch (opcao) {
                case 1:
                    // Agendar
                    agendarConsulta();
                    break;
                case 2:
                    // Listar
                    listarConsultas();
                    break;
                case 3:
                    // Atualizar
                    atualizarConsulta();
                    break;
                case 4:
                    // Excluir
                    cancelarConsulta();
                    break;
                case 5:
                    // Voltar
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        } while (opcao != 5);
    }

    public static void agendarConsulta() {
        String dataConsulta = JOptionPane.showInputDialog("Data da Consulta (dd/MM/yyyy)");
        String horarioInicio = JOptionPane.showInputDialog("Horário de Início (HH:mm)");
        String stringDuracao = JOptionPane.showInputDialog("Duração (minutos)");
        int duracao = Integer.parseInt(stringDuracao);
        String status = JOptionPane.showInputDialog("Status");
        String cpfpaciente = JOptionPane.showInputDialog("CPF do Paciente");
        String stringCrm = JOptionPane.showInputDialog("CRM do Médico");
        int crmMedico = Integer.parseInt(stringCrm);

        String stringValor = JOptionPane.showInputDialog("Valor");
        double valor = Double.parseDouble(stringValor);

        Consulta consulta = new Consulta(dataConsulta, horarioInicio, duracao, status, servicoPaciente.buscarPacientePorCpf(cpfpaciente), servicoMedico.buscarMedicoPorCrm(crmMedico), null, null, valor);

        try {
            servicoConsulta.agendarConsulta(consulta);
        } catch (ConsultaJaExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return;
        }
    }

    public static void listarConsultas(){
        servicoConsulta.listarConsultas();
    }

    public static void atualizarConsulta() {
        String dataAntigaStr = JOptionPane.showInputDialog("Data da Consulta Antiga (dd/MM/yyyy)");
        LocalDate dataAntiga = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dataAntiga = LocalDate.parse(dataAntigaStr, formatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Data de Consulta inválida");
            return;
        }

        String horarioAntigoStr = JOptionPane.showInputDialog("Horário de Início Antigo (HH:mm)");
        LocalTime horarioAntigo = null;
        try {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            horarioAntigo = LocalTime.parse(horarioAntigoStr, timeFormatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Horário de Início inválido");
            return;
        }

        int crmMedico = Integer.parseInt(JOptionPane.showInputDialog("CRM do Médico"));
        String novaDataConsulta = JOptionPane.showInputDialog("Nova Data da Consulta (dd/MM/yyyy)");
        String novoHorarioInicio = JOptionPane.showInputDialog("Novo Horário de Início (HH:mm)");
        int novaDuracao = Integer.parseInt(JOptionPane.showInputDialog("Nova Duração (minutos)"));
        String novoStatus = JOptionPane.showInputDialog("Novo Status");
        String cpfPaciente = JOptionPane.showInputDialog("CPF do Paciente");

        String novoValor = JOptionPane.showInputDialog("Novo Valor");
        double valor = Double.parseDouble(novoValor);

        Consulta novaConsulta = new Consulta(novaDataConsulta, novoHorarioInicio, novaDuracao, novoStatus, servicoPaciente.buscarPacientePorCpf(cpfPaciente), servicoMedico.buscarMedicoPorCrm(crmMedico), null, null, valor);

        try {
            servicoConsulta.atualizarConsulta(dataAntiga, horarioAntigo, servicoMedico.buscarMedicoPorCrm(crmMedico), novaConsulta);
        } catch (ConsultaNaoEncontradaException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return;
        }
    }

    public static void cancelarConsulta() {
        String dataStr = JOptionPane.showInputDialog("Data da Consulta Antiga (dd/MM/yyyy)");
        LocalDate data = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            data = LocalDate.parse(dataStr, formatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Data de Consulta inválida");
            return;
        }
        String horarioStr = JOptionPane.showInputDialog("Horário de Início Antigo (HH:mm)");
        LocalTime horario = null;
        try {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            horario = LocalTime.parse(horarioStr, timeFormatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Horário de Início inválido");
            return;
        }
        String stringCrm = JOptionPane.showInputDialog("CRM do Médico");
        int crmMedico = Integer.parseInt(stringCrm);

        try {
            servicoConsulta.removerConsulta(data, horario, servicoMedico.buscarMedicoPorCrm(crmMedico));
        } catch (ConsultaNaoEncontradaException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
