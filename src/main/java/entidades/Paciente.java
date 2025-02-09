package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends entidades.Pessoa {

    private String telefone;
    private String email;

    private List<String> historicoExames;
    private boolean pagamentoPendente;

    public Paciente(String nome, String cpf, LocalDate dataNascimento, String telefone, String email) {
        super(nome, cpf, dataNascimento);
        this.historicoExames = new ArrayList<>();
        this.pagamentoPendente = false;
        this.telefone = telefone;
        this.email = email;
    }

    public List<String> getHistoricoExames() {
        return historicoExames;
    }

    public void adicionarExame(String exame) {
        historicoExames.add(exame);
    }

    public boolean isPagamentoPendente() {
        return pagamentoPendente;
    }

    public void bloquearCadastro() {
        this.pagamentoPendente = true;
    }

    public void realizarPagamento() {
        this.pagamentoPendente = false;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}