package entidades;

import excecoes.CpfInvalidoException;
import java.time.LocalDate;


public class Pessoa {

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    protected HistoricoMedico historicoMedico;

    // Construtor
    public Pessoa(String nome, String cpf, LocalDate dataNascimento) throws CpfInvalidoException {
        this.nome = nome;
        setCpf(cpf); // Verificação do CPF
        this.dataNascimento = dataNascimento;
        this.historicoMedico = new HistoricoMedico();
    }

    // Getter e Setter para nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para CPF
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws CpfInvalidoException {
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d+")) {
            throw new CpfInvalidoException("CPF inválido. Deve conter exatamente 11 dígitos.");
        }
        this.cpf = cpf;
    }

    // Getter e Setter para Data de Nascimento
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // Getter para histórico médico
    public HistoricoMedico getHistoricoMedico() {
        return historicoMedico;
    }
    public void setHistoricoMedico(HistoricoMedico historicoMedico) {
        this.historicoMedico = historicoMedico;
    }
}
