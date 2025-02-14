package menu;

import java.util.List;
import javax.swing.JOptionPane;
import entidades.Exame;;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        String dataPrescricaoStr = JOptionPane.showInputDialog("Data de Prescrição (dd/MM/yyyy)");
        double custo = Double.parseDouble(JOptionPane.showInputDialog("Custo"));
        LocalDate dataPrescricao = null;
        try {
            dataPrescricao = LocalDate.parse(dataPrescricaoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data inválida");
            return;
        }
        Exame exame = new Exame(tipo, dataPrescricao, custo);
    }

    public static void listarExames() {
        List<Exame> exames = servicoExame.listarExames();
        String lista = "";
        for (Exame exame : exames) {
            lista += exame + "\n";
        }
        JOptionPane.showMessageDialog(null, lista);
    }

    public static void atualizarExame() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID do Exame"));
        Exame exame = servicoExame.buscarExameporId(id);
        if (exame == null) {
            JOptionPane.showMessageDialog(null, "Exame não encontrado");
            return;
        }
        String tipo = JOptionPane.showInputDialog("Tipo do Exame", exame.getTipo());
        String dataPrescricaoStr = JOptionPane.showInputDialog("Data de Prescrição (dd/MM/yyyy)", exame.getDataPrescricao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        double custo = Double.parseDouble(JOptionPane.showInputDialog("Custo", exame.getCusto()));
        LocalDate dataPrescricao = null;
        try {
            dataPrescricao = LocalDate.parse(dataPrescricaoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data inválida");
            return;
        }
        exame.setTipo(tipo);
        exame.setDataPrescricao(dataPrescricao);
        exame.setCusto(custo);
        servicoExame.atualizarExame(id,exame);
    }

    public static void removerExame() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID do Exame"));
        Exame exame = servicoExame.buscarExameporId(id);
        if (exame == null) {
            JOptionPane.showMessageDialog(null, "Exame não encontrado");
            return;
        }
        servicoExame.removerExame(exame);
    }

    
}
