package menu;
import javax.swing.JOptionPane;
import servicos.ServicoConsulta;
import excecoes.ConsultaJaExisteException;
import excecoes.ConsultaNaoEncontradaException;
import entidades.Consulta;
import 

public class MenuConsulta {

    static ServicoConsulta servicoConsulta = new ServicoConsulta();
    public static void menuConsulta()
    {
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
                    listarConsulta();
                    break;
                case 3:
                    // Atualizar
                    atualizarConsulta();
                    break;
                
                case 4:
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

    public static void agendarConsulta(){
        String dataConsulta = JOptionPane.showInputDialog("Data da Consulta (dd/MM/yyyy)");
        String horarioInicio = JOptionPane.showInputDialog("Horário de Início (hh:mm)");
        int duracao = Integer.parseInt(JOptionPane.showInputDialog("Duração(em minutos)"));
        String status = JOptionPane.showInputDialog("Status");
        String cpfPaciente = JOptionPane.showInputDialog("CPF do Paciente");
        String cpfMedico = JOptionPane.showInputDialog("CPF do Médico");
        String examesPrescritos = JOptionPane.showInputDialog("Exames Prescritos");
        String medicamentosPrescritos = JOptionPane.showInputDialog("Medicamentos Prescritos");
        String valor = JOptionPane.showInputDialog("Valor");

        Consulta consulta = new Consulta(dataConsulta, horarioInicio, duracao, status, cpfPaciente, cpfMedico, examesPrescritos, medicamentosPrescritos, valor);
        try {
            servicoConsulta.agendarConsulta(consulta);
        } catch (ConsultaJaExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
