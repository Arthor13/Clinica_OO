package entidades;

import excecoes.CpfInvalidoException;
import java.time.LocalDate;

public class Paciente extends entidades.Pessoa {

    private String telefone;
    private String email;

    private boolean pagamentoPendente;

    public Paciente(String nome, String cpf, LocalDate dataNascimento, String telefone, String email) throws CpfInvalidoException {
        super(nome, cpf, dataNascimento);
        this.pagamentoPendente = false;
        this.telefone = telefone;
        this.email = email;
    }

    public void adicionarExame(Exame exame) {
        historicoMedico.adicionarExame(exame);
    }

    public boolean getPagamentoPendente() {
        return pagamentoPendente;
    }

    public void setPagamentoPendente(boolean pagamentoPendente) {
        this.pagamentoPendente = pagamentoPendente;
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

    public String toString() {
        return "Nome: " + getNome() + "\nCPF: " + getCpf() + "\nData de Nascimento: " + getDataNascimento() + "\nTelefone: " + telefone + "\nEmail: " + email;
    }
}