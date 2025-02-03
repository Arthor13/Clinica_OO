package model;


public class Pessoa {

    private String nome;
    private String cpf;
    private String dataNascimento;

    // Construtor
    public Pessoa(String nome, String cpf, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
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

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Getter e Setter para Data de Nascimento
    public String getData() {
        return dataNascimento;
    }

    public void setData(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


}
