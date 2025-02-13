package menu;
import javax.swing.JOptionPane;
import entidades.Consulta;
import entidades.Paciente;
import servicos.ServicoConsulta;
import excecoes.ConsultaJaExisteException;
import excecoes.ConsultaNaoEncontradaException;
import entidades.Paciente;
import entidades.Medico;
import servicos.ServicoMedico;
import servicos.ServicoPaciente;
public class MenuConsulta {
    static ServicoPaciente servicoPaciente = new ServicoPaciente();
    static ServicoMedico servicoMedico = new ServicoMedico();
    static ServicoConsulta servicoConsulta = new ServicoConsulta();

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
        String dataConsulta = JOptionPane.showInputDialog("Data da Consulta");

        String horarioInicio = JOptionPane.showInputDialog("Horário de Início");

        String stringDuracao = JOptionPane.showInputDialog("Duração");
        int duracao = Integer.parseInt(stringDuracao);

        String status = JOptionPane.showInputDialog("Status");
        String cpfpaciente = JOptionPane.showInputDialog("CPF do Paciente");

        String stringCrm = JOptionPane.showInputDialog("CRM do Médico");
        int crmMedico = Integer.parseInt(stringCrm);

        String examesPrescritos = JOptionPane.showInputDialog("Exames Prescritos");

        String medicamentosPrescritos = JOptionPane.showInputDialog("Medicamentos Prescritos");

        String stringValor = JOptionPane.showInputDialog("Valor");
        double valor = Double.parseDouble(stringValor);

        Consulta consulta = new Consulta(dataConsulta, horarioInicio, duracao, status, servicoPaciente.buscarPacientePorCpf(cpfpaciente), servicoMedico.buscarMedicoPorCrm(crmMedico), examesPrescritos, medicamentosPrescritos, valor);

        try {
            servicoConsulta.agendarConsulta(consulta);
        } catch (ConsultaJaExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void listarConsultas(){
        servicoConsulta.listarConsultas();
    }

    
    /*public static void atualizarConsulta(){
        String dataAntiga = JOptionPane.showInputDialog("Data da Consulta Antiga");
        String horarioAntigo = JOptionPane.showInputDialog("Horário de Início Antigo");
        String crmMedico = JOptionPane.showInputDialog("CRM do Médico");
        String novaDataConsulta = JOptionPane.showInputDialog("Nova Data da Consulta");
        String novoHorarioInicio = JOptionPane.showInputDialog("Novo Horário de Início");
        String novaDuracao = JOptionPane.showInputDialog("Nova Duração");
        String novoStatus = JOptionPane.showInputDialog("Novo Status");
        String cpfPaciente = JOptionPane.showInputDialog("CPF do Paciente");
        String examesPrescritos = JOptionPane.showInputDialog("Exames Prescritos");
        String medicamentosPrescritos = JOptionPane.showInputDialog("Medicamentos Prescritos");
        String novoValor = JOptionPane.showInputDialog("Novo Valor");
        Consulta novaConsulta = new Consulta(novaDataConsulta, novoHorarioInicio, novaDuracao, novoStatus, cpfPaciente, crmMedico, examesPrescritos, medicamentosPrescritos, novoValor);
        try {
            servicoConsulta.atualizarConsulta(dataAntiga, horarioAntigo, crmMedico, novaConsulta);
        } catch (ConsultaNaoEncontradaException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    */
        public static void excluirConsulta(){
            String data = JOptionPane.showInputDialog("Data da Consulta");
            String horario = JOptionPane.showInputDialog("Horário de Início");
            
            String stringCrm = JOptionPane.showInputDialog("CRM do Médico");
            int crmMedico = Integer.parseInt(stringCrm);
            
            try {
                servicoConsulta.removerConsulta(data, horario, servicoMedico.buscarMedicoPorCrm(crmMedico));
            } catch (ConsultaNaoEncontradaException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
    }
}
