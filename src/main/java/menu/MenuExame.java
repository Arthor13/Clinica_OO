package menu;

import java.util.List;
import javax.swing.JOptionPane;
import entidades.Exame;
import excecoes.ExameNaoEncontradoException;
import excecoes.ExameJaExisteException;
import java.time.LocalDate;

import servicos.ServicoExame;

public class MenuExame {

    static ServicoExame servicoExame = new ServicoExame();

    public static void menuExame()
    {
        int opcao = 0;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu Exame\n1 - Cadastrar\n2 - Listar\n3 - Atualizar\n4 - Remover\n5 - Voltar"));
            switch (opcao) {
                case 1:
                    // Cadastrar
                    cadastrarExame();
                    break;
                case 2:
                    // Listar
                    listarExames();
                    break;
                case 3:
                    // Atualizar
                    atualizarExame();
                    break;
                case 4:
                    // Remover
                    removerExame();
                    break;
                case 5:
                    // Voltar
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        } while (opcao != 5);
    }

    public static void cadastrarExame() {
        String tipo = JOptionPane.showInputDialog("Tipo do Exame");
        String dataPrescricao = JOptionPane.showInputDialog("Data de Prescrição (dd/MM/yyyy)");
        String stringCusto = JOptionPane.showInputDialog("Custo");
        Double custo = Double.parseDouble(stringCusto);
        LocalDate dataPrescricaoFormatada = LocalDate.parse(dataPrescricao, servicoExame.getFormatoData());
        try {
            servicoExame.cadastrarExame(tipo, dataPrescricaoFormatada, custo);
        } catch (ExameJaExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }
    
}
