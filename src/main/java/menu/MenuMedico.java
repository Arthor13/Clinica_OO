package menu;

import javax.swing.JOptionPane;
import entidades.Medico;
import java.time.LocalDate;
import servicos.ServicoMedico;
import excecoes.MedicoJaExisteException;
import java.lang.classfile.Signature;
import java.lang.classfile.instruction.ThrowInstruction;
public class MenuMedico {
    static ServicoMedico servicoMedico = new ServicoMedico();
    public static void menuMedico() {
       
        int opcao = 0;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu Medico\n1 - Cadastrar\n2 - Listar\n3 - Atualizar\n4 - Excluir\n5 - Voltar"));
            switch (opcao) {
                case 1:
                    // Cadastrar
                    cadastrarMedico();
                case 2:
                    // Listar
                   listarMedico();
                case 3:
                    // Atualizar
                    atualizarMedico();
                case 4:
                    // Excluir
                    excluirMedico();
                case 5:
                    // Voltar
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        } while (opcao != 5);
    }


   public static void cadastrarMedico(){
        String nome = JOptionPane.showInputDialog("Nome");
        String cpf = JOptionPane.showInputDialog("CPF");
        String dataNascimento = JOptionPane.showInputDialog("Data de Nascimento");
        int crm = Integer.parseInt(JOptionPane.showInputDialog("CRM"));
        String especialidade = JOptionPane.showInputDialog("Especialidade");
        Medico medico = new Medico(nome, cpf, dataNascimento, crm, especialidade);
        try {
            servicoMedico.cadastrarMedico(medico);
        } catch (MedicoJaExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void listarMedico(){
        servicoMedico.listarMedicos();
    }

    public static void atualizarMedico(){
        int crm = Integer.parseInt(JOptionPane.showInputDialog("CRM"));
        String nome = JOptionPane.showInputDialog("Nome");
        String cpf = JOptionPane.showInputDialog("CPF");
        LocalDate dataNascimento = JOptionPane.showInputDialog("Data de Nascimento");
        String especialidade = JOptionPane.showInputDialog("Especialidade");
        Medico medico = new Medico(nome, cpf, dataNascimento, crm, especialidade);
        servicoMedico.atualizarMedico(crm, medico);
    }

    public static void excluirMedico(){
        int crm = Integer.parseInt(JOptionPane.showInputDialog("CRM"));
        servicoMedico.removerMedico(crm);
    }