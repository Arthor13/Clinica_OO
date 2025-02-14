package main;

import javax.swing.JOptionPane;
import menu.MenuConsulta;
import menu.MenuExame;
import menu.MenuMedico;
import  menu.MenuPaciente;

public class Principal {
    public static void main(String[] args) {
        int opcao = 0;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("1 - Menu Médico\n2 - Menu Paciente\n3 - Menu Consulta\n4 - Menu Exame\n5 - Sair"));
            switch (opcao) {
                case 1:
                    MenuMedico.menuMedico();
                    break;
                case 2:
                    MenuPaciente.menuPaciente();
                    break;
                case 3:
                    MenuConsulta.menuConsulta();
                    break;
                case 4:
                    MenuExame.menuExame();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break; 
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opcao != 5);
    }


    
}